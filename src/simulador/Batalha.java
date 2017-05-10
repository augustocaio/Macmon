package simulador;

public class Batalha extends Controller{
	Ataque A1 = new Ataque("Trovom", 35, 4); // pichu, raichu
	Ataque A2 = new Ataque("Rabada", 40, 5); // pichu, raichu, gyarados,  mew, mewtwo, arboc, squirtle, charmander
	Ataque A3 = new Ataque("Patada", 25, 2); // pichu, raichu
	Ataque A4 = new Ataque("Chidori", 50, 6); // raichu
	
	Ataque A5 = new Ataque("Cuspe", 20, 1); // squirtle, rubbish
	Ataque A6 = new Ataque("Enxague", 40, 4); // gyarados, squirtle
	Ataque A7 = new Ataque("Jato", 45, 5); // gyarados, squirtle
	Ataque A8 = new Ataque("Flash Beam", 60, 7); // gyarados, mewtwo, mew
	Ataque A9 = new Ataque("Empurrom", 40, 5); //mew, mewtwo
	Ataque A10 = new Ataque("Surto Psicotico", 70, 9);//mewtwo
	Ataque A11 = new Ataque("Piripaque", 70, 9);//mew
	Ataque A12 = new Ataque("Curticao", 20, 1);//rolezera
	Ataque A13 = new Ataque("Ficar", 35, 4);//rolezera
	Ataque A14 = new Ataque("Ideia-Errada", 40, 5);//rolezera
	Ataque A15 = new Ataque("Sacrificio", 70, 9);//rolezera
	Ataque A16 = new Ataque("Ataques Muito-Brutos", 65, 8);//gato
	Ataque A17 = new Ataque("Invocacao", 50, 6);//gato
	Ataque A18 = new Ataque("Xaveco", 30, 3);//gato
	Ataque A19 = new Ataque("Enaltecer", 40, 4);//gato
	Ataque A20 = new Ataque("Faisca", 40, 5);// pichu
	//FAZER O RESTO DOS ATAQUES
	/*Ataque A20 = new Ataque("");
	Ataque A21 = new Ataque("");
	Ataque A22 = new Ataque("");*/
	
	Pokemon P1 = new Pokemon("Gyarados", 100, "agua", "raio", A6, A7, A8, A2);
	Pokemon P2 = new Pokemon("Squirtle", 100, "agua","raio", A5, A7, A6, A2);
	Pokemon P3 = new Pokemon("Raichu", 100, "raio", "terra", A1, A4, A3, A2);
	Pokemon P4 = new Pokemon("Pichu", 100, "raio", "terra", A1, A20, A3, A2);
	Pokemon P5 = new Pokemon("Mew", 100, "psico", "dark", A8, A9, A11, A2);
	Pokemon P6 = new Pokemon("MewTwo", 100, "psico", "dark", A8, A9, A10, A2);
	Pokemon P7 = new Pokemon("Rolezera", 100, "dark", "psico", A12, A13, A14, A15);//curtissaum, ficar, ideia errada, sacrificar
	Pokemon P8 = new Pokemon("Gato do Role", 100, "dark", "psico", A16, A17, A18, A19);//brutos, chega bejando, xaveco, enaltecer
	//FAZER O RESTO DOS POKEMONS
	/*Pokemon P9 = new Pokemon("Dragonite", 100, "dragao", , "veneno");
	Pokemon P10 = new Pokemon("Charmander", 100, "fogo", "agua");
	Pokemon P11 = new Pokemon("Arboc", 100, "veneno", "dragao");
	Pokemon P12 = new Pokemon("Rubbish", 100, "terra", "agua");*/
	
	Treinador t1 = new Treinador("Trash", P1, P2, P3, P4, P5, P6);
	Treinador t2 = new Treinador("Dusty", P1, P2, P3, P4, P5, P6);

	private class Troca extends Event{
		private Treinador t;
		private Pokemon[] p;	
		private Pokemon aux;
		public Troca(long eventTime, Pokemon[] p, int numeroDoPokemon){
			super(eventTime);
			this.p = p;
			
		}
		public void action(){
			aux = p[0];
			int i = 0;
			while(true){
				i++;
				if(p[i].status == true){
					p[0] = p[i];
					p[i] = aux;
					break;
				}
			}			
		}
		public String description(){
			return "O Pokemon "+aux.pegaNome()+" foi substituido por "+p[0].pegaNome();
		}
	}
	
	
	
	private class Turno extends Event{
		Treinador t1;
		Treinador t2;
		public Turno (long eventTime, Treinador t1, Treinador t2 ){
			super(eventTime);
			this.t1 = t1;
			this.t2 = t2;
			
		}		
		public void action(){
			if(t1.status && t2.status){
				
				// oq falta: opcoes -> fugir - trocar pokemon - item - atacar
				
				
				//se todos os pokemons de um usurario morreram status = inativo
				
				//if pro item: se hp é 0 nao da pra usar o item, usar o boolean de pokemon vivo
				
				//if para se o pokemon morrer, trocar o pokemon e quando atacar e ofor  hp 0 ou menor que zero ele fica morto
				if( t1.status == false){
					fimDaBatalha( t1.pegaNome());
				}
			}
		}
		public String description(){
			return "Fim do turno.";
		}
		
	}
	
	
	
	
	
	public String fimDaBatalha(String Vencedor){
		return "O vencedor da batalha foi: "+Vencedor;
	}
	
	
	
	
	
	
	public static void main(String[] args){
		
		
		
	}

}