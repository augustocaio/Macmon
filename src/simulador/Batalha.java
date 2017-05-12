package simulador;

import java.util.Arrays;

public class Batalha extends Controller{
	// mudar valores de velocidade dos ataques para algo "decente"
	Habilidade A1 = new Habilidade("Trovom", 35, 4); // pichu, raichu
	Habilidade A2 = new Habilidade("Rabada", 40, 5); // pichu, raichu, gyarados,  mew, mewtwo, arbok, squirtle, charmander
	Habilidade A3 = new Habilidade("Patada", 25, 2); // pichu, raichu
	Habilidade A4 = new Habilidade("Chidori", 50, 6); // raichu
	Habilidade A5 = new Habilidade("Cuspe", 20, 1); // arbok, squirtle, rubbish
	Habilidade A6 = new Habilidade("Enxague", 40, 4); // gyarados, squirtle
	Habilidade A7 = new Habilidade("Jato", 45, 5); // gyarados, squirtle
	Habilidade A8 = new Habilidade("Hyper Beam", 60, 7); // gyarados, mewtwo, mew, dragonite
	Habilidade A9 = new Habilidade("Empurrom", 40, 5); //mew, mewtwo
	Habilidade A10 = new Habilidade("Surto Psicotico", 70, 9);//mewtwo
	Habilidade A11 = new Habilidade("Piripaque", 70, 9);//mew
	Habilidade A12 = new Habilidade("Curticao", 20, 1);//rolezera
	Habilidade A13 = new Habilidade("Ficar", 35, 4);//rolezera
	Habilidade A14 = new Habilidade("Ideia-Errada", 40, 5);//rolezera
	Habilidade A15 = new Habilidade("Sacrificio", 70, 9);//rolezera
	Habilidade A16 = new Habilidade("Ataques Muito-Brutos", 65, 8);//gato
	Habilidade A17 = new Habilidade("Invocacao", 50, 6);//gato
	Habilidade A18 = new Habilidade("Xaveco", 30, 3);//gato
	Habilidade A19 = new Habilidade("Enaltecer", 40, 4);//gato
	Habilidade A20 = new Habilidade("Faisca", 40, 5);// pichu
	Habilidade A21 = new Habilidade("Mordida", 35, 4);// arbok
	Habilidade A22 = new Habilidade("Poison Sting", 35, 4);// arbok
	Habilidade A23 = new Habilidade("Furacao", 80, 10); //dragonite
	Habilidade A24 = new Habilidade("Dragon Tail", 50, 6);// dragonite
	Habilidade A25 = new Habilidade("Lança-Chamas", 50, 6);
	Habilidade A26 = new Habilidade("Bola de fogo", 45, 5);
	Habilidade A27 = new Habilidade("Toxico", 50, 6);
	Habilidade A28 = new Habilidade("Toxic Spray", 35, 4);
	Habilidade A29 = new Habilidade("Jogar Terra", 25, 2);
	
	Potion SuperPocao = new Potion("Super Potion", 5, 100);
	Potion Pocao = new Potion("Potion", 10, 50);
	
	
	Pokemon P1 = new Pokemon("Gyarados", 100, "agua", "raio", A6, A7, A8, A2);
	Pokemon P2 = new Pokemon("Squirtle", 100, "agua","raio", A5, A7, A6, A2);
	Pokemon P3 = new Pokemon("Raichu", 100, "raio", "terra", A1, A4, A3, A2);
	Pokemon P4 = new Pokemon("Pichu", 100, "raio", "terra", A1, A20, A3, A2);
	Pokemon P5 = new Pokemon("Mew", 100, "psico", "dark", A8, A9, A11, A2);
	Pokemon P6 = new Pokemon("MewTwo", 100, "psico", "dark", A8, A9, A10, A2);
	Pokemon P7 = new Pokemon("Rolezera", 100, "dark", "psico", A12, A13, A14, A15);//curtissaum, ficar, ideia errada, sacrificar
	Pokemon P8 = new Pokemon("Gato do Role", 100, "dark", "psico", A16, A17, A18, A19);//brutos, chega bejando, xaveco, enaltecer
	Pokemon P9 = new Pokemon("Arbok", 100, "veneno", "dragao", A2, A5, A21, A22);
	Pokemon P10 = new Pokemon("Dragonite", 100, "dragao", "veneno", A8, A23, A2, A24);
	Pokemon P11 = new Pokemon("Charmander", 100, "fogo", "agua", A2, A3, A25, A26);	
	Pokemon P12 = new Pokemon("Rubbish", 100, "terra", "agua", A5, A27, A28, A29);
	
	Treinador t1 = new Treinador("Trash", P1, P2, P12, P4, P5, P6);
	Treinador t2 = new Treinador("Dusty", P3, P8, P9, P10, P11, P7);
	
	
	//0 - CLASSE chamar no final da main(?) ou de algum evento
	private class FinalizaBatalha extends Event{
		Treinador Vencedor;
		Treinador Perdedor;
		public FinalizaBatalha (long eventTime, Treinador W, Treinador L ){
			super(eventTime);
			Vencedor = W;
			Perdedor = L;
		}
		public void action(){
			this.description();
		};
		public String description(){
			return "O vencedor da batalha é: "+Vencedor.pegaNome()+"\nE o perdedor é: "+Perdedor.pegaNome();
		} 
	}
	// 1- CLASSE QUE TROCA O POKEMON
	private class Troca extends Event{
		private Treinador t;
		private int qual;
		/*private Pokemon[] p;*/	
		private Pokemon aux;
		int i;
		
		public Troca(long eventTime, Treinador t, int which/*de 1 a 4*/){
			super(eventTime);
			this.t = t;
			qual = which;
			/*this.p = p;*/
			
		}
		public void action(){
			aux = t.pokemon[0];
			int i = 0;
			if(t == t1){
				if(t1.pokemon[qual].status == true){
					t1.pokemon[0] = t.pokemon[qual];
					t1.pokemon[qual] = aux;
				}
			}
			if(t == t2){
				if(t2.pokemon[qual].status == true){
					t2.pokemon[0] = t.pokemon[qual];
					t2.pokemon[qual] = aux;
				}
			
			}
			if(aux.status == false){
				//troca pelo proximo vivo
				while(true){
					//i começa com 1
					i++;
					if(t == t1){
						if(t1.pokemon[i].status == true){
							t1.pokemon[0] = t1.pokemon[i];
							t1.pokemon[i] = aux;
							description();
							break;
						}
					}
					if(t == t2){
						if(t2.pokemon[i].status == true){
							t2.pokemon[0] = t2.pokemon[i];
							t2.pokemon[i] = aux;
							description();
							break;
						}
					}	
					if(i > 5 && aux.status == false){
						//FINALIZA A BATALHA
						//Se o t for o primeiro treinador, quem perde é o treinador 1,
						//caso contrário o perdedor é o 2
						//O perdedor fica como ultimo argumento no contrutor do FinalizaBatalha
						if(t == t1){
							addEvent(new FinalizaBatalha(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, t1));
						}
						else addEvent(new FinalizaBatalha(System.currentTimeMillis() + 1000, t1/*VENCEDOR*/, t2));
						
						break;
					}
					else{
						if(t == t1){
							t1.pokemon[0] = aux;
							break;
						}
						else {
							t2.pokemon[0] = aux;
							break;
						}
					}
				}
			}
		}		
		
		public String description(){
			if(i == 5){
				//talvez isso deva ser deletado porque ja teria evento FinalizaBatalha
				return "Todos os Pokemons de "+t.pegaNome()+" estão inativos.";
			}
			else 
				return "O Pokemon "+aux.pegaNome()+", do Treinador " +t.pegaNome()+", foi substituido pelo Pokemon "+t.pokemon[0].pegaNome();
		}
	}
	
	// 2- CLASSE DE ATAQUE DE UM POKEMON A OUTRO
	private class Ataque extends Event{
		Treinador atc, def;
		Habilidade hab;
		double seTemFraqueza = 0;
		double dano;
		int index = 0;
		//No construtor deve por o treinador, a habilidade do pokemon t1.p[0].hab[0]
		public Ataque (long eventTime, Treinador atacante, Treinador atacado, Habilidade habilidade ){
			super(eventTime);
			atc = atacante;
			def = atacado;
			hab = habilidade;
			dano = hab.pegaDano();
			
		}		
		public void action(){
			//SE O TIPO DO ATACANTE FOR A FRAQUEZA DO DEFENSOR			
			if(atc.pokemon[0].pegaTipo().equals(def.pokemon[0].pegaFraqueza())){
				index = Arrays.asList(atc.pokemon[0].hab).indexOf(this.hab);
				
				if(def.pegaNome() == t1.pegaNome()){
					System.out.println("*************\nVida de "+t1.pokemon[0].pegaNome()+": "+t1.pokemon[0].hp);
				}
				if(def.pegaNome() == t2.pegaNome()){
					System.out.println("*************\nVida de "+t2.pokemon[0].pegaNome()+": "+t2.pokemon[0].hp);
				}
				//CUIDADO QUE O DANO DA HABILIDADE DEVE SER PEGA PELO METODO
				dano = 1.5*hab.pegaDano();
				System.out.println("*************\nATAQUE:\nDANO: "+dano);			
				
				if(def.pegaNome() == t1.pegaNome()){
					t1.pokemon[0].setVida(dano);
					System.out.println("*************\nVida de "+t1.pokemon[0].pegaNome()+": "+t1.pokemon[0].hp);
					if(t1.pokemon[0].pegaHP() <= 0){
						MataPokemon(t1);
					}
				}
				if(def.pegaNome() == t2.pegaNome()){
					t2.pokemon[0].setVida(dano);
					System.out.println("*************\nVida de "+t2.pokemon[0].pegaNome()+": "+t2.pokemon[0].hp);
					if(t2.pokemon[0].pegaHP() <= 0){
						MataPokemon(t2);
					}
				}
				description();
				
			} 
			else {
				if(def.pegaNome() == t1.pegaNome()){
					System.out.println("*************\nVida de "+t1.pokemon[0].pegaNome()+": "+t1.pokemon[0].hp);
				}
				if(def.pegaNome() == t2.pegaNome()){
					System.out.println("*************\nVida de "+t2.pokemon[0].pegaNome()+": "+t2.pokemon[0].hp);
				}
				index = Arrays.asList(atc.pokemon[0].hab).indexOf(this.hab);
				System.out.println("*************\nATAQUE:\nDANO: "+dano);	
				def.pokemon[0].hp -= 1.5*hab.pegaDano();				
				
				if(def.pegaNome() == t1.pegaNome()){
					t1.pokemon[0].setVida(dano);
					System.out.println("*************\nVida de "+t1.pokemon[0].pegaNome()+":  "+t1.pokemon[0].hp);
					if(t1.pokemon[0].pegaHP() <= 0){
						MataPokemon(t1);
					}
				}
				if(def.pegaNome() == t2.pegaNome()){
					t2.pokemon[0].setVida(dano);
					System.out.println("*************\nVida de "+t2.pokemon[0].pegaNome()+":  "+t2.pokemon[0].hp);
					if(t2.pokemon[0].pegaHP() <= 0){
						MataPokemon(t2);
					}
				}
					description();
			}
		}
		public String description(){
			if(atc.pokemon[0].pegaTipo().equals(def.pokemon[0].pegaFraqueza())){
				if(def.pegaNome() == t1.pegaNome())
				return "O Pokemon "+t2.pokemon[0].pegaNome()+ " atacou com "+t2.pokemon[0].pegaAtaque(index).pegaNome()+
						" o Pokemon "+t1.pokemon[0].pegaNome()  + ", que perdeu "+dano
						+" de HP, agora tendo "+t1.pokemon[0].hp+" HP";
				else
					return "O Pokemon "+t1.pokemon[0].pegaNome()+ " atacou com "+t1.pokemon[0].pegaAtaque(index).pegaNome()+
							" o Pokemon "+t2.pokemon[0].pegaNome()  + ", que perdeu "+dano
							+" de HP, agora tendo "+t2.pokemon[0].hp+" HP";
			} else {
				if(def.pegaNome() == t1.pegaNome())
					return "O Pokemon "+t2.pokemon[0].pegaNome()+ " atacou com "+t2.pokemon[0].pegaAtaque(index).pegaNome()+
							" o Pokemon "+t1.pokemon[0].pegaNome()  + ", que perdeu "+dano
							+" de HP, agora tendo "+t1.pokemon[0].hp+" HP";
					else
						return "O Pokemon "+t1.pokemon[0].pegaNome()+ " atacou com "+t1.pokemon[0].pegaAtaque(index).pegaNome()+
								" o Pokemon "+t2.pokemon[0].pegaNome()  + ", que perdeu "+dano
								+" de HP, agora tendo "+t2.pokemon[0].hp+" HP";
			}
		}
	}
	
	// 3 - CLASSE DE CURAR
	private class Curar extends Event{
		Treinador t;
		Potion pocao;
		public Curar (long eventTime, Treinador t, Potion I){
			super(eventTime);
			this.t = t;
			this.pocao = I;
		}
		public void action(){
			if(t.pokemon[0].hp != 0){
				t.pokemon[0].hp += pocao.pegaEfeito();
				if(t.pokemon[0].hp>100){
					t.pokemon[0].hp = 100;
				}
				pocao.qtd--;
			}
			/*if(pocao.pegaNome().equals("Potion") && t.pokemon[0].hp != 0){
				t.pokemon[0].hp += 50;
				if(t.pokemon[0].hp>100){
					t.pokemon[0].hp = 100;
				}
			}*/
		}
		public String description(){
			return "O Pokemon "+t.pokemon[0].pegaNome()+" foi curado com " + 
					pocao.pegaNome() + " e tem " +t.pokemon[0].hp+" de HP.";
		}
	}
	// 4 - CLASSE DE USAR POKEBOLA (ATENÇÃO: COMPLETAR PARA A ETAPA 2)
	/*
	private class Captura extends Event{
		public Captura (long eventTime, Treinador t, Pokemon Wild){
			super(eventTime);
		}
		public void action(){
			
		}
		public String description(){
			
		}
	}*/
	
	// 5 - CLASSE PARA A FUGA
	public class Fuga extends Event{
		Treinador t;
		
		public Fuga(long eventTime, Treinador fugitivo){
			super(eventTime);
			t = fugitivo;
		}
		public void action(){
			description();
			if(t == t1){
				addEvent(new FinalizaBatalha(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, t1));
			}
			else{
				
				addEvent(new FinalizaBatalha(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, t2));
			}
		}
		public String description(){
			return "O treinador "+t.pegaNome()+" fugiu da batalha.";
		}
	}
	// 6 - METODO PRA DETERMINAR OS EVENTOS as escolhas vão de 1 a 7
	public void ComputaEscolhas(int mov1, int mov2){
		if(mov1 == 1){
			addEvent(new Fuga(System.currentTimeMillis() + /*adiciona 1s*/1000, t1));
		}
		if(mov2 == 1 && mov1 != 1){
			addEvent(new Fuga(System.currentTimeMillis() + /*adiciona 1s*/1000, t2));
		}
		//troca o primeiro pelo segundo pokemon do vetor
		if(mov1 == 2 && mov2 != 1){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, 1));
		}
		if(mov2 == 2){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, 1));
		}
		//troca o primeiro pelo terceiro pokemon do vetor
		if(mov1 == 3 && mov2 != 1){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, 2));
		}
		if(mov2 == 3){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, 2));
		}
		//troca o primeiro pelo quarto pokemon do vetor
		if(mov1 == 4 && mov2 != 1){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, 3));
		}
		if(mov2 == 4){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, 3));
		}// troca o primeiro pelo quinto pokemon
		if(mov1 == 5 && mov2 != 1){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, 4));
		}
		if(mov2 == 5){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, 4));
		}// troca o primeiro pelo sexto
		if(mov1 == 6 && mov2 != 1){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, 5));
		}
		if(mov2 == 6){
			addEvent(new Troca(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, 5));
		}
		//Usa item de cura Super Potion
		if(mov1 == 7 && mov2 != 1){
			addEvent(new Curar(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, SuperPocao));
		}
		if(mov2 == 7){
			addEvent(new Curar(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, SuperPocao));
		}
		//Usa item de cura Potion
		if(mov1 == 8 && mov2 != 1){
			addEvent(new Curar(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, Pocao));
		}
		if(mov2 == 8){
			addEvent(new Curar(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, Pocao));
		}
		//Se os personagens estao atacando:
		if(mov1 >= 9 && mov1 <= 14 && mov2 >= 9 && mov2 <= 14){
			//seta o numero dos ataques no vetor ataque de pokemon
			int at1 = mov1-9, at2 = mov2-9;
			Pokemon a;
			if(t1.pokemon[0].hab[at1].pegaVelocidade() <= t2.pokemon[0].hab[at2].pegaVelocidade()){
				a = t2.pokemon[0];
				addEvent(new Ataque(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, t2, t1.pokemon[0].hab[at1]));
				if(a == t2.pokemon[0]){
					addEvent(new Ataque(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, t1, t2.pokemon[0].hab[at2]));
				}
			}
			else{
				a = t1.pokemon[0];
				addEvent(new Ataque(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, t1, t2.pokemon[0].hab[at2]));
				if(a == t1.pokemon[0]){
					addEvent(new Ataque(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, t2, t1.pokemon[0].hab[at1]));
				}
			}
		}
		if(mov1 >= 9 && mov1 <=14 && mov2 < 9){
			int at1 = mov1-9;
			addEvent(new Ataque(System.currentTimeMillis() + /*adiciona 1s*/1000, t1, t2, t1.pokemon[0].hab[at1]));	
		}
		if(mov2 >= 9 && mov2 <=14 && mov1 < 9){
			int at2 = mov2-8;
			addEvent(new Ataque(System.currentTimeMillis() + /*adiciona 1s*/1000, t2, t1, t2.pokemon[0].hab[at2]));	
		}
	}
	public void MataPokemon (Treinador x){
		if(x.pegaNome() == t1.pegaNome()){
			t1.pokemon[0].status = false;
			addEvent(new Troca(System.currentTimeMillis() + 1000, t1 , 1));
		}
		if(x.pegaNome() == t2.pegaNome()){
			t2.pokemon[0].status = false;
			addEvent(new Troca(System.currentTimeMillis() + 1000, t2 , 1));
		}
		
		
	}
	private void setEscolhas(int[] mov1, int[] mov2){
		int i = 0, j =0;
		while(i< mov1.length || i< mov2.length){
			ComputaEscolhas(mov1[i],mov2[j]);
			if(i<mov1.length)
				i++;
			if(j<mov2.length)
				j++;
		}

	}
	//VER COMO O RUN() FUNCIONA, SE ELE CONTINUA O VETOR ATÉ ACABAR OS 100 EVENTOS, OU TEMOS QUE PARA-LO
	
	public static void main(String[] args){
		Batalha bt = new Batalha();
		int[] escolhas1 = {12, 10, 12};
		int[] escolhas2 = {10, 9, 7};
		// 1 - fuga, 2~6- troca pelo 1~5, 7 - super potion, 8 - potion 
		// 9 -> ataque 0, 10 -> ataque 1, 11 -> ataque 2, 12 -> ataque 3
		bt.setEscolhas(escolhas1, escolhas2);
		bt.run();
		
	}

}