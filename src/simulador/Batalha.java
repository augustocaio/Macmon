package simulador;

import java.util.Arrays;

public class Batalha extends Controller{

	Treinador t1;
	Treinador t2;
	public Batalha (Treinador tr1, Treinador tr2){
		t1 = tr1;
		t2 = tr2;
	}
	
	//0 - CLASSE chamar no final da main(?) ou de algum evento
	/*private class FinalizaBatalha extends Event{
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
	}*/
	// 1- CLASSE QUE TROCA O POKEMON
	private class Troca extends Event{
		private Treinador t;
		private int qual; //qual pokemon foi escolhido pra sofrer troca
		/*private Pokemon[] p;*/	
		private Pokemon aux;
		
		public Troca(long eventTime, Treinador t, int which/*de 1 a 4*/){
			super(eventTime);
			this.t = t;
			qual = which;
			/*this.p = p;*/
			
		}
		public void action(){
			aux = t.pokemon[0];
			if(t.wild == false){
				t.troca(qual);
			}
			else{
				t.status = false;
			}
			
		}		
		
		public String description(){
			if(t1.status == false || t2.status==false){
				if(t1.status == false){
					if(t2.wild == false) return "---------------------------------------\nA Batalha terminou\n---------------------------------------"
							+ "\n---------------------------------------\nO Treinador "+t2.pegaNome()+" venceu a batalha.\n---------------------------------------";
					else return "---------------------------------------\nA Batalha terminou\n---------------------------------------"
					+ "\n---------------------------------------\nO Pokemon Selvagem "+t2.pokemon[0].pegaNome()+" venceu a batalha.\n---------------------------------------";
				}
					
				else {
					return "---------------------------------------\nA Batalha terminou\n---------------------------------------"
								+ "\n---------------------------------------\nO Treinador "+t1.pegaNome()+" venceu a batalha\n---------------------------------------";
				}
			
			}
			else {
				if(t.wild == false){
					return "O Pokemon "+aux.pegaNome()+", do Treinador " +t.pegaNome()+", foi substituido pelo Pokemon "+t.pokemon[0].pegaNome()+"\n---------------------------------------";
				}
				else
					return "O Pokemon "+t.pokemon[0].pegaNome()+" foi derrotado\n---------------------------------------";
				
			}
		}
	}
	
	// 2- CLASSE DE ATAQUE DE UM POKEMON A OUTRO
	private class Ataque extends Event{
		Treinador atacante, atacado;
		Habilidade habilidade;
		double dano;
		
		//No construtor deve por o treinador, a habilidade do pokemon t1.p[0].hab[0]
		public Ataque (long eventTime, Treinador atacante, Treinador atacado, Habilidade habilidade ){
			super(eventTime);
			this.atacante = atacante;
			this.atacado = atacado;
			this.habilidade = habilidade;
			dano = habilidade.pegaDano();
			
		}	
		public void action(){
			if(atacante == t1){
				t2.pokemon[0].setVida(habilidade.pegaDano());
				if(t2.pokemon[0].status == false){
					//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
					//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
					//System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
					/*System.out.println("Antes");
					for(int m = 0; m<5; m++){
						System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
					}*/
					//System.out.println(description());
					//addEvent(new Troca(System.currentTimeMillis(), t2, 1));
					//run();
					/*System.out.println("Depois");
					for(int m = 0; m<5; m++){
						System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
					}*/
					
					return;
				}
			} 
			if( atacante == t2){
				t1.pokemon[0].setVida(habilidade.pegaDano());
				if(t1.pokemon[0].status == false){
					/*System.out.println("ataque: Antes");
					for(int m = 0; m<5; m++){
						System.out.println("O Pokemon "+t1.pokemon[m].pegaNome()+" de indice "+m+ " status " +t1.pokemon[m].status);
					}*/
					//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
					//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
					//System.out.println(t1.pokemon[0].pegaNome()+" agora esta invalido.");
					//System.out.println(description());
					//addEvent(new Troca(System.currentTimeMillis(), t1, 1));
					//run();
					/*System.out.println("Depois");
					for(int m = 0; m<5; m++){
						System.out.println("O Pokemon "+t1.pokemon[m].pegaNome()+" de indice "+m+ " status " +t1.pokemon[m].status);
					}*/
					return;
				}
			}
			//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
					//"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP"
					//		+ "\n---------------------------------------");
		}
		
		public String description(){
			int index = Arrays.asList(atacante.pokemon[0].hab).indexOf(habilidade);

			return "O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
						"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+dano+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------";

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
			if(t.wild == false)
			t.curar(pocao);
		}
		public String description(){
			if(t.wild == false)
				return "O Pokemon "+t.pokemon[0].pegaNome()+" foi curado com " + 
					pocao.pegaNome() + " e tem " +t.pokemon[0].hp+" de HP.\n---------------------------------------";
			else 
				return "O Pokemon e selvagem e nao pode se curar\n---------------------------------------";
		}
	}
	// 4 - CLASSE DE USAR POKEBOLA (ATENÇÃO: COMPLETAR PARA A ETAPA 2)
	
	private class Captura extends Event{
		Pokebola pokebola;
		boolean captura;
		public Captura (long eventTime, Pokebola pokebola){
			super(eventTime);
			this.pokebola = pokebola;
			captura = false;
		}
		public void action(){
			if(t2.wild == true){
				int r = 0 + (int)(Math.random() * ((200) + 1));
				pokebola.qtd--;
			}
			
		}
		public String description(){
			if(captura == true){
				return "O Pokemon "+t2.pokemon[0].pegaNome()+" foi capturado com sucesso\n---------------------------------------";
			}
			else
				if(t2.wild == true)
					return "O Pokemon "+t2.pokemon[0].pegaNome()+" nao foi capturado\n---------------------------------------";
				else
					return "O Pokemon de outro treinador nao pode ser capturado\n---------------------------------------";
		}
	}
	
	// 5 - CLASSE PARA A FUGA
	public class Fuga extends Event{
		Treinador t;
		
		public Fuga(long eventTime, Treinador fugitivo){
			super(eventTime);
			t = fugitivo;
		}
		public void action(){
			t.corre();
		}
		public String description(){
			if(t.wild ==false)
				return "O treinador "+t.pegaNome()+" fugiu da batalha.\n---------------------------------------";
			else return "O Pokemon selvagem fugiu da batalha.\n---------------------------------------";
		}
	}

	
	//  - METODO PRA DETERMINAR OS EVENTOS as escolhas vÃ£o de 1 a 7
		public void ComputaEscolhas(int mov1, int mov2){
			if( t1.status == true && t2.status == true){
				if(mov1 == 1){
					addEvent(new Fuga(System.currentTimeMillis(), t1));
					run();
				}
				if(mov2 == 1 && mov1 != 1){
					addEvent(new Fuga(System.currentTimeMillis(), t2));
					run();
				}
				//troca o primeiro pelo segundo pokemon do vetor
				if(mov1 == 2 && mov2 != 1){
					addEvent(new Troca(System.currentTimeMillis(), t1, 1));
					run();
				}
				if(mov2 == 2){
					addEvent(new Troca(System.currentTimeMillis(), t2, 1));
					run();
				}
				//troca o primeiro pelo terceiro pokemon do vetor
				if(mov1 == 3 && mov2 != 1){
					addEvent(new Troca(System.currentTimeMillis(), t1, 2));
					run();
				}
				if(mov2 == 3){
					addEvent(new Troca(System.currentTimeMillis(), t2, 2));
					run();
				}
				//troca o primeiro pelo quarto pokemon do vetor
				if(mov1 == 4 && mov2 != 1){
					addEvent(new Troca(System.currentTimeMillis(), t1, 3));
					run();
				}
				if(mov2 == 4){
					addEvent(new Troca(System.currentTimeMillis(), t2, 3));
					run();
				}// troca o primeiro pelo quinto pokemon
				if(mov1 == 5 && mov2 != 1){
					addEvent(new Troca(System.currentTimeMillis(), t1, 4));
					run();
				}
				if(mov2 == 5){
					t2.troca(4);
				}// troca o primeiro pelo sexto
				if(mov1 == 6 && mov2 != 1){
					addEvent(new Troca(System.currentTimeMillis(), t1, 5));
					run();
				}
				if(mov2 == 6){
					addEvent(new Troca(System.currentTimeMillis(), t2, 5));
					run();
				}
				//Usa item de cura Super Potion
				if(mov1 == 7 && mov2 != 1){
					addEvent(new Curar(System.currentTimeMillis(), t1, (Potion)t1.itens[1]));
					run();
				}
				if(mov2 == 7){
					addEvent(new Curar(System.currentTimeMillis(), t2, (Potion)t2.itens[1]));
					run();
				}
				//Usa item de cura Potion
				if(mov1 == 8 && mov2 != 1){
					addEvent(new Curar(System.currentTimeMillis(), t1, (Potion)t1.itens[0]));
					run();
				}
				if(mov2 == 8){
					addEvent(new Curar(System.currentTimeMillis(), t2, (Potion)t2.itens[0]));
					run();
				}
				//Se os pokemons estao atacando:
				if(mov1 >= 9 && mov1 <= 12 && mov2 >= 9 && mov2 <= 12){
					double health;
					double damage;
				//	Boolean fraq = false;
					if(t1.pokemon[0].status == true && t2.pokemon[0].status == true){
						//seta o numero dos ataques no vetor ataque de pokemon
						int at1 = mov1-9, at2 = mov2-9;
						//System.out.println("1");
						if(t1.pokemon[0].hab[at1].pegaVelocidade() >= t2.pokemon[0].hab[at2].pegaVelocidade()){
							//System.out.println("2");
							if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
								//System.out.println("3");
								t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() * 1.5);

							}
							//System.out.println("ATAQUE NORMAL DO POKE COM MAIS SPD");
							
							health = t2.pokemon[0].hp;
							damage = t1.pokemon[0].hab[at1].pegaDano();
							//System.out.println("habilidade "+t1.pokemon[0].hab[at1].pegaNome()+" dano: "+t1.pokemon[0].hab[at1].pegaDano()+" indice: "+at1);
							if(t1.status == true && t2.status == true){
								addEvent(new Ataque(System.currentTimeMillis(), t1, t2, t1.pokemon[0].hab[at1] ));
								run();
							}
							
							
							if(t2.pokemon[0].hp<=0){
								t2.pokemon[0].status = false;
								//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
								//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
								//System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
								/*System.out.println("Antes");
								for(int m = 0; m<5; m++){
									System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
								}*/
								if(t1.status == true && t2.status == true){
									addEvent(new Troca(System.currentTimeMillis(), t2, 1));
									run();
								}
								/*System.out.println("Depois");
								for(int m = 0; m<5; m++){
									System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
								}*/
							}
							
							
							
							//caso o pokemon morra, ele nao pode mais atacar
							if(health>damage ){
								//System.out.println("5");
								// o contra ataque tbm tem q checar fraqueza
								if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
									//System.out.println("6");
									//t2.pokemon[0].hab[at1].dano = t2.pokemon[0].hab[at1].dano*1.5;
									t2.pokemon[0].hab[at2].setDano(t2.pokemon[0].hab[at2].pegaDano() * 1.5);
								}
								
								//System.out.println("ATAQUE NORMAL NA DO POKEMON MAIS LENTO");
								if(t1.status == true && t2.status == true){
									addEvent(new Ataque(System.currentTimeMillis(), t2, t1, t2.pokemon[0].hab[at2] ));
									run();
								}
								if(t1.pokemon[0].hp<=0){
									t1.pokemon[0].status = false;
									//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
									//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
									//System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
									/*System.out.println("Antes");
									for(int m = 0; m<5; m++){
										System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
									}*/
									if(t1.status == true && t2.status == true){
										addEvent(new Troca(System.currentTimeMillis(), t1, 1));
										run();
									}
									/*System.out.println("Depois");
									for(int m = 0; m<5; m++){
										System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
									}*/
								}
								// voltar ao dano normal
								if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
									//System.out.println("7");
									t2.pokemon[0].hab[at2].setDano(t2.pokemon[0].hab[at2].pegaDano() / 1.5);
									//t2.pokemon[0].hab[at2].dano = t2.pokemon[0].hab[at2].dano/1.5;
								} 
								
							} 
							
							if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
								//System.out.println("4");
								t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() / 1.5);

							}
							
							if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
								//System.out.println("8");
								//t1.pokemon[0].hab[at1].dano = t1.pokemon[0].hab[at1].dano/1.5;
								t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() / 1.5);
							} 
							
						} else {
							//System.out.println("9");
							if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
								//System.out.println("10");
								//t2.pokemon[0].hab[at2].dano = t2.pokemon[0].hab[at2].dano*1.5;
								t2.pokemon[0].hab[at2].setDano(t2.pokemon[0].hab[at2].pegaDano() * 1.5);
							}
							//System.out.println("ATAQUE NORMAL");
							if(t1.status == true && t2.status == true){
								addEvent(new Ataque(System.currentTimeMillis(), t2, t1, t2.pokemon[0].hab[at2] ));
								run();
							}
							
							if(t1.pokemon[0].hp<=0){
								t1.pokemon[0].status = false;
								//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
								//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
								//System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
								/*System.out.println("Antes");
								for(int m = 0; m<5; m++){
									System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
								}*/
								if(t1.status == true && t2.status == true){
									addEvent(new Troca(System.currentTimeMillis(), t1, 1));
									run();
								}
								/*System.out.println("Depois");
								for(int m = 0; m<5; m++){
									System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
								}*/
							}
							

							health = t1.pokemon[0].hp;
							damage = t2.pokemon[0].hab[at2].pegaDano();
							//caso o pokemon morra, ele nao pode mais atacar
							if(health>damage){
								//System.out.println("12");
								// contra ataque tem q checar fraqueza
								if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
									//System.out.println("13");
									//t1.pokemon[0].hab[at1].dano = t1.pokemon[0].hab[at1].dano*1.5;
									t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() * 1.5);
								}
								//System.out.println("habilidade "+t1.pokemon[0].hab[at1].pegaNome()+" dano: "+t1.pokemon[0].hab[at1].pegaDano());
								//System.out.println("ATAQUE NORMAL, TURNO DO POKE COM MENOS VELOCIDADE");
								if(t1.status == true && t2.status == true){
									addEvent(new Ataque(System.currentTimeMillis(), t1, t2, t1.pokemon[0].hab[at1] ));
									run();
								}
								
								if(t2.pokemon[0].hp<=0){
									t2.pokemon[0].status = false;
									//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
									//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
									//System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
									/*System.out.println("Antes");
									for(int m = 0; m<5; m++){
										System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
									}*/
									if(t1.status == true && t2.status == true){
										addEvent(new Troca(System.currentTimeMillis(), t2, 1));
										run();
									}
									/*System.out.println("Depois");
									for(int m = 0; m<5; m++){
										System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
									}*/
								}
								// voltar ao dano normal
								if(t1.pokemon[0].pegaTipo().equals(t2.pokemon[0].pegaFraqueza())){
									//System.out.println("14");
									//t1.pokemon[0].hab[at1].dano = t1.pokemon[0].hab[at1].dano/1.5;
									t1.pokemon[0].hab[at1].setDano(t1.pokemon[0].hab[at1].pegaDano() / 1.5);
								} 
								
							}
							
							if(t2.pokemon[0].pegaTipo().equals(t1.pokemon[0].pegaFraqueza())){
								//System.out.println("11");
								//t2.pokemon[0].hab[at2].dano = t2.pokemon[0].hab[at2].dano/1.5;
								t2.pokemon[0].hab[at2].setDano(t2.pokemon[0].hab[at2].pegaDano() / 1.5);
							} 
							
							
						}	
					}
					
				}
				
				if(mov1 >= 9 && mov1 <=12 && mov2 < 9){
					int at1 = mov1-9;
					//System.out.println("15");
					if(t1.pokemon[0].status == true && t2.pokemon[0].status == true && t1.status == true && t2.status == true){
						addEvent(new Ataque(System.currentTimeMillis(), t1, t2, t1.pokemon[0].hab[at1] ));
						run();
						
						if(t2.pokemon[0].hp<=0 && t1.status == true && t2.status == true){
							t2.pokemon[0].status = false;
							//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
							//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
							//System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
							/*System.out.println("Antes");
							for(int m = 0; m<5; m++){
								System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
							}*/
							addEvent(new Troca(System.currentTimeMillis(), t2, 1));
							run();
							/*System.out.println("Depois");
							for(int m = 0; m<5; m++){
								System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
							}*/
						}
						
					}	
				}
				if(mov2 >= 9 && mov2 <=12 && mov1 < 9 && t1.status == true && t2.status == true){
					int at2 = mov2-9;
					//System.out.println("16");
			//		if(t1.pokemon[0].status == true && t2.pokemon[0].status == true){
			//			System.out.println("5");
			//			Ataque ( t2, t1, t2.pokemon[0].hab[at2]);	
			//		}
					addEvent(new Ataque(System.currentTimeMillis(), t2, t1, t2.pokemon[0].hab[at2] ));
					run();
					
					if(t1.pokemon[0].hp<=0 && t1.status == true && t2.status == true){
						t1.pokemon[0].status = false;
						//System.out.println("O Pokemon "+atacante.pokemon[0].pegaNome()+" atacou "+atacado.pokemon[0].pegaNome()+" com "+atacante.pokemon[0].hab[index].pegaNome()+
						//		"\n"+atacado.pokemon[0].pegaNome()+" perdeu "+habilidade.pegaDano()+"HP, agora tem "+atacado.pokemon[0].hp+"HP\n---------------------------------------");
						//System.out.println(t2.pokemon[0].pegaNome()+" agora esta invalido.");
						/*System.out.println("Antes");
						for(int m = 0; m<5; m++){
							System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
						}*/
						addEvent(new Troca(System.currentTimeMillis(), t1, 1));
						run();
						/*System.out.println("Depois");
						for(int m = 0; m<5; m++){
							System.out.println("O Pokemon "+t2.pokemon[m].pegaNome()+" de indice "+m+ " status " +t2.pokemon[m].status);
						}*/
					}
				}
				System.out.println("Fim do Turno\n---------------------------------------");
				
			}
			
		}
		
		
		


	
	/*public static void main(String[] args){
		
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
				Habilidade A25 = new Habilidade("Lanca-Chamas",         50,        70);
				Habilidade A26 = new Habilidade("Bola de fogo",          45,        75);
				Habilidade A27 = new Habilidade("Toxico",                50,        70);
				Habilidade A28 = new Habilidade("Toxic Spray",           35,        85);
				Habilidade A29 = new Habilidade("Jogar Terra",           25,        95);
																	//  dano     velocidade
				
				Potion SuperPocao = new Potion("Super Potion", 5, 100);
				Potion Pocao = new Potion("Potion", 10, 50);
				
				
				Pokemon P1 = new Pokemon("Gyarados", 	100, "agua", 	"raio",		A6,		A7, 	A8, 	A2);
				Pokemon P2 = new Pokemon("Squirtle", 	100, "agua",	"raio",		A5,		A7, 	A6, 	A2);
				Pokemon P3 = new Pokemon("Raichu", 		100, "raio", 	"terra", 	A1, 	A4, 	A3, 	A2);
				Pokemon P4 = new Pokemon("Pichu", 		100, "raio", 	"terra",	A1,		A20, 	A3, 	A2);
				Pokemon P5 = new Pokemon("Mew", 		100, "psico",	"dark",	 	A8,		A9, 	A11, 	A2);
				Pokemon P6 = new Pokemon("MewTwo", 		100, "psico",	"dark",	 	A8,		A9, 	A10, 	A2);
				Pokemon P7 = new Pokemon("Rolezera", 	100, "dark", 	"psico",	A12,	A13,	A14, 	A15);//curtissaum, ficar, ideia errada, sacrificar
				Pokemon P8 = new Pokemon("Gato do Role",100, "dark", 	"psico",	A16,	A17, 	A18, 	A19);//brutos, chega bejando, xaveco, enaltecer
				Pokemon P9 = new Pokemon("Arbok", 		100, "veneno", 	"dragao",	A2,		A5, 	A21, 	A22);
				Pokemon P10 = new Pokemon("Dragonite", 	100, "dragao", 	"veneno", 	A8,	 	A23, 	A2, 	A24);
				Pokemon P11 = new Pokemon("Charmander", 100, "fogo", 	"agua", 	A2,	 	A3, 	A25, 	A26);	
				Pokemon P12 = new Pokemon("Rubbish", 	100, "terra", 	"agua", 	A5,	 	A27, 	A28, 	A29);
				
				Item[] i1 = {Pocao, SuperPocao};
				Item[] i2 = {Pocao, SuperPocao};
				Pokemon[] p1 = {P1, P2, P3, P4, P5, P6};
				Pokemon[] p2 = {P7, P8, P9, P10, P11, P12};
				
				Treinador t1 = new Treinador("Trash", false, p1 , i1, 0, 0 );
				Treinador t2 = new Treinador("Dusty", false, p2, i2, 0, 0);
		Batalha bt = new Batalha(t1, t2);
		// 1 - fuga, 2~6- troca pelo 1~5, 7 - super potion, 8 - potion 
		// 9 -> ataque 0, 10 -> ataque 1, 11 -> ataque 2, 12 -> ataque 3
		bt.ComputaEscolhas(9, 9);
		bt.ComputaEscolhas(10, 10);
		bt.ComputaEscolhas(11,  11);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 10);
		bt.ComputaEscolhas(12, 11);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		bt.ComputaEscolhas(12, 12);
		
		
		
		bt.run();
		
	}*/

}