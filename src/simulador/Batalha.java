package simulador;

import java.util.Arrays;

public class Batalha extends Controller{
	// mudar valores de velocidade dos ataques para algo "decente"
	Habilidade A1 = new Habilidade("Trovom",                 35,        85); // pichu, raichu
	Habilidade A2 = new Habilidade("Rabada",       	         40,        80); // pichu, raichu, gyarados,  mew, mewtwo, arbok, squirtle, charmander
	Habilidade A3 = new Habilidade("Patada",                 25,        95); // pichu, raichu
	Habilidade A4 = new Habilidade("Chidori",                50,        70); // raichu
	Habilidade A5 = new Habilidade("Cuspe",                  20,        100); // arbok, squirtle, rubbish
	Habilidade A6 = new Habilidade("Enxague",                40,        80); // gyarados, squirtle
	Habilidade A7 = new Habilidade("Jato",                   45,        75); // gyarados, squirtle
	Habilidade A8 = new Habilidade("Hyper Beam",             60,        65); // gyarados, mewtwo, mew, dragonite
	Habilidade A9 = new Habilidade("Empurrom",               40,        80); //mew, mewtwo
	Habilidade A10 = new Habilidade("Surto Psicotico",       70,        60);//mewtwo
	Habilidade A11 = new Habilidade("Piripaque",             70,        60);//mew
	Habilidade A12 = new Habilidade("Curticao",              20,        100);//rolezera
	Habilidade A13 = new Habilidade("Ficar",                 35,        85);//rolezera
	Habilidade A14 = new Habilidade("Ideia-Errada",          40,        90);//rolezera
	Habilidade A15 = new Habilidade("Sacrificio",            70,        60);//rolezera
	Habilidade A16 = new Habilidade("Ataques Muito-Brutos",  65,        65);//gato
	Habilidade A17 = new Habilidade("Invocacao",             50,        70);//gato
	Habilidade A18 = new Habilidade("Xaveco",                30,        90);//gato
	Habilidade A19 = new Habilidade("Enaltecer",             40,        80);//gato
	Habilidade A20 = new Habilidade("Faisca",                40,        80);// pichu
	Habilidade A21 = new Habilidade("Mordida",               35,        85);// arbok
	Habilidade A22 = new Habilidade("Poison Sting",          35,        85);// arbok
	Habilidade A23 = new Habilidade("Furacao",               80,        50); //dragonite
	Habilidade A24 = new Habilidade("Dragon Tail",           50,        70);// dragonite
	Habilidade A25 = new Habilidade("Lança-Chamas",         50,        70);
	Habilidade A26 = new Habilidade("Bola de fogo",          45,        75);
	Habilidade A27 = new Habilidade("Toxico",                50,        70);
	Habilidade A28 = new Habilidade("Toxic Spray",           35,        85);
	Habilidade A29 = new Habilidade("Jogar Terra",           25,        95);
														//  dano     velocidade
	
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
	
	Treinador t1 = new Treinador("Trash", P1, P2, P3, P4, P5, P6);
	Treinador t2 = new Treinador("Dusty", P7, P8, P9, P10, P11, P12);
	
	
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

	
	// 2- ATAQUE DE UM POKEMON A OUTRO
	public void Ataque ( Treinador atacante, Treinador atacado, Habilidade habilidade ) {
		int index = Arrays.asList(atacante.pokemon[0].hab).indexOf(habilidade);
		if(atacante == t1){
			t2.pokemon[0].setVida(habilidade.pegaDano());
			if(t2.pokemon[0].status == false){
				System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
						"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
				System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
				t2.troca(1);	
				t2.pokemon[0].status = true;
				return;
			}
		} 
		if( atacante == t2){
			t1.pokemon[0].setVida(habilidade.pegaDano());
			if(t1.pokemon[0].status == false){
				System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
						"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
				System.out.println(t1.pokemon[0].pegaNome()+" agora esta invalido.");
				t1.troca(1);
				t1.pokemon[0].status = true;
				return;
			}
		}
		System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
				"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP"
						+ "\n---------------------------------------");
	}
	

	// 6 - METODO PRA DETERMINAR OS EVENTOS as escolhas vão de 1 a 7
	public void ComputaEscolhas(int mov1, int mov2){
		if(mov1 == 1){
			t1.corre();
		}
		if(mov2 == 1 && mov1 != 1){
			t2.corre();
		}
		//troca o primeiro pelo segundo pokemon do vetor
		if(mov1 == 2 && mov2 != 1){
			t1.troca(1);
		}
		if(mov2 == 2){
			t2.troca(1);
		}
		//troca o primeiro pelo terceiro pokemon do vetor
		if(mov1 == 3 && mov2 != 1){
			t1.troca(2);
		}
		if(mov2 == 3){
			t2.troca(2);
		}
		//troca o primeiro pelo quarto pokemon do vetor
		if(mov1 == 4 && mov2 != 1){
			t1.troca(3);
		}
		if(mov2 == 4){
			t2.troca(3);
		}// troca o primeiro pelo quinto pokemon
		if(mov1 == 5 && mov2 != 1){
			t1.troca(4);
		}
		if(mov2 == 5){
			t2.troca(4);
		}// troca o primeiro pelo sexto
		if(mov1 == 6 && mov2 != 1){
			t1.troca(5);
		}
		if(mov2 == 6){
			t2.troca(5);
		}
		//Usa item de cura Super Potion
		if(mov1 == 7 && mov2 != 1){
			t1.curar(SuperPocao);
		}
		if(mov2 == 7){
			t2.curar(SuperPocao);
		}
		//Usa item de cura Potion
		if(mov1 == 8 && mov2 != 1){
			t1.curar(Pocao);
		}
		if(mov2 == 8){
			t2.curar(Pocao);
		}
		//Se os pokemons estao atacando:
		if(mov1 >= 9 && mov1 <= 12 && mov2 >= 9 && mov2 <= 12){
		//	Boolean fraq = false;
			if(t1.pokemon[0].status == true && t2.pokemon[0].status == true){
				//seta o numero dos ataques no vetor ataque de pokemon
				int at1 = mov1-9, at2 = mov2-9;
				
				if(t1.pokemon[0].hab[at1].pegaVelocidade() >= t2.pokemon[0].hab[at2].pegaVelocidade()){
					if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
						//t1.pokemon[0].hab[at1].dano = t1.pokemon[0].hab[at1].dano*1.5;
						t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() * 1.5);
					//	fraq = true;
					}
					System.out.println("ATAQUE NORMAL DO POKE COM MAIS SPD");
					Ataque ( t1, t2, t1.pokemon[0].hab[at1] );
			//		if(fraq = true) {
			//			System.out.print("Ataque super efetivo!");
			//		}
					
					//caso o pokemon morra, ele nao pode mais atacar
					if(t1.pokemon[0].hp - t2.pokemon[0].hab[at2].pegaDano() >= 0){
						
						// o contra ataque tbm tem q checar fraqueza
						if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
							//t2.pokemon[0].hab[at1].dano = t2.pokemon[0].hab[at1].dano*1.5;
							t2.pokemon[0].hab[at2].setDano(t2.pokemon[0].hab[at2].pegaDano() * 1.5);
						}
						
						System.out.println("ATAQUE NORMAL, TURNO DO POKE COM MENOS SPD");
						Ataque ( t2, t1, t2.pokemon[0].hab[at2] );
						
						// voltar ao dano normal
						if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
							t2.pokemon[0].hab[at2].setDano(t2.pokemon[0].hab[at2].pegaDano() / 1.5);
							//t2.pokemon[0].hab[at2].dano = t2.pokemon[0].hab[at2].dano/1.5;
						} 
						
					} else {
					}
					
					if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
						//t1.pokemon[0].hab[at1].dano = t1.pokemon[0].hab[at1].dano/1.5;
						t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() / 1.5);
					} 
					
				} else {
					if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
						t2.pokemon[0].hab[at2].dano = t2.pokemon[0].hab[at2].dano*1.5;
						t1.pokemon[0].hab[at2].setDano(t1.pokemon[0].hab[at2].pegaDano() * 1.5);
					}
					System.out.println("ATAQUE NORMAL");
					Ataque ( t2, t1, t2.pokemon[0].hab[at2]);
					
					//caso o pokemon morra, ele nao pode mais atacar
					if(t2.pokemon[0].hp - t1.pokemon[0].hab[at1].pegaDano() >= 0){
						
						// contra ataque tem q checar fraqueza
						if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
							//t1.pokemon[0].hab[at1].dano = t1.pokemon[0].hab[at1].dano*1.5;
							t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() * 1.5);
						}
						
						System.out.println("ATAQUE NORMAL, TURNO DO POKE COM MENOS SPD");
						Ataque ( t1, t2, t1.pokemon[0].hab[at1]);
						
						// voltar ao dano normal
						if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
							//t1.pokemon[0].hab[at1].dano = t1.pokemon[0].hab[at1].dano/1.5;
							t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() / 1.5);
						} 
						
					} else {
						// preciso ignorar o ataque do pokemon trocado
					}
					
					if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
						//t2.pokemon[0].hab[at2].dano = t2.pokemon[0].hab[at2].dano/1.5;
						t2.pokemon[0].hab[at2].setDano(t2.pokemon[0].hab[at2].pegaDano() / 1.5);
					} 
				}	
			}
			
		}
		if(mov1 >= 9 && mov1 <=12 && mov2 < 9){
			int at1 = mov1-9;
			if(t1.pokemon[0].status == true && t2.pokemon[0].status == true){
				System.out.println("4");
				Ataque ( t1, t2, t1.pokemon[0].hab[at1]);
			}	
		}
		if(mov2 >= 9 && mov2 <=12 && mov1 < 9){
			int at2 = mov2-9;
	//		if(t1.pokemon[0].status == true && t2.pokemon[0].status == true){
	//			System.out.println("5");
	//			Ataque ( t2, t1, t2.pokemon[0].hab[at2]);	
	//		}
				System.out.println("5");
				Ataque ( t2, t1, t2.pokemon[0].hab[at2]);	
		}
		
	}
	
	public static void main(String[] args){
		Batalha bt = new Batalha();
		// 1 - fuga, 2~6- troca pelo 1~5, 7 - super potion, 8 - potion 
		// 9 -> ataque 0, 10 -> ataque 1, 11 -> ataque 2, 12 -> ataque 3
		// testar fraqueza
		// treinador 2 ganha do 1 por elimina��o de pokemons, usar aleatoriamente po��es sei l�
		bt.ComputaEscolhas(9, 9); // gyarados 80 hp / rolezera 60hp (ataques sem fraqueza)
		
		bt.ComputaEscolhas(10, 10); // gyarados 45 hp / rolezera 15hp (ataques sem fraqueza)
		
		bt.ComputaEscolhas(12, 12); // gyarados mais spd entao ataca rolezera q morre -> troca por gato, gyarados 15hp
		
		bt.ComputaEscolhas(8, 9); // gyarados cura 50 e toma um ataque de 65, morre -> troca por squirtle
		// 1 morto de kd lado 
		bt.ComputaEscolhas(10, 9); // squirtle 35hp, gato 65hp
		
		bt.ComputaEscolhas(11, 11); // squirtle 5hp, gato 15hp
		
		bt.ComputaEscolhas(10, 11); // squirtle 0 hp (atk mais lento morreu antes)
		// 2 mortos t1 e 1 morto t2
		bt.ComputaEscolhas(10, 6); // rubbish no lugar do gato, rubbish 50hp
		
		bt.ComputaEscolhas(9, 10); // raichu 25hp e rubbish 15hp
		// fraquezas ok, talvez printar algo como "super efetivo"
		bt.ComputaEscolhas(8, 7); // raichu 75 e rubbish 100
		
		bt.ComputaEscolhas(10, 10); // rip raichu -> pichu, rubbish 50
		// 3 mortos pro t1 e 1 morto pro t2
		bt.ComputaEscolhas(10, 12); // rubbish 10, pichu 62
		
		bt.ComputaEscolhas(9, 11); // rubbish rip -> gato, pichu 30
		// 3-2
		bt.ComputaEscolhas(5, 11); // troca pichu por mew, mew 70hp
		
		bt.ComputaEscolhas(9, 10); // mew rip -> pichu, gato sei la qnto de hp
		// 4-2
		bt.ComputaEscolhas(12, 9); // rip gato -> arbok, pichu com 30
		// 4-3
		bt.ComputaEscolhas(12, 9);
		bt.run();
		
	}
	/*public void MataPokemon (Treinador x){
		int m;
		if(x.pegaNome() == t1.pegaNome()){
			t1.pokemon[0].status = false;

				System.out.println("ANTES");
				
			for(m = 0; m<=5; m++){
				System.out.println("Pokemon do indice: "+m+" é "+t1.pokemon[m].pegaNome()+" e seu status é "+t1.pokemon[m].status );
			}
			
			t1.troca(1);
			
			System.out.println("DEPOIS");
			
			for(m = 0; m<=5; m++){
				System.out.println("Pokemon do indice: "+m+" é "+t1.pokemon[m].pegaNome()+" e seu status é "+t1.pokemon[m].status );
			}
		}
		if(x.pegaNome() == t2.pegaNome()){
			t2.pokemon[0].status = false;

			System.out.println("ANTES");
			
			for(m = 0; m<=5; m++){
				System.out.println("Pokemon do indice: "+m+" é "+t2.pokemon[m].pegaNome()+" e seu status é "+t2.pokemon[m].status );
			}
		
			t2.troca(1);
		
			System.out.println("DEPOIS");
		
			for(m = 0; m<=5; m++){
				System.out.println("Pokemon do indice: "+m+" é "+t2.pokemon[m].pegaNome()+" e seu status é "+t2.pokemon[m].status );
			}
		}
		
		
	}*/
	/*private void setEscolhas(int[] mov1, int[] mov2){
		int i = 0, j =0;
		while(i< mov1.length || i< mov2.length){
			ComputaEscolhas(mov1[i],mov2[j]);
			if(i<mov1.length)
				i++;
			if(j<mov2.length)
				j++;
		}
	}
	*/
	//VER COMO O RUN() FUNCIONA, SE ELE CONTINUA O VETOR ATÉ ACABAR OS 100 EVENTOS, OU TEMOS QUE PARA-LO
	


}