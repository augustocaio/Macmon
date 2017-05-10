package simulador;

public class Batalha extends Controller{
	Habilidade A1 = new Habilidade("Trovom", 35, 4); // pichu, raichu
	Habilidade A2 = new Habilidade("Rabada", 40, 5); // pichu, raichu, gyarados,  mew, mewtwo, arboc, squirtle, charmander
	Habilidade A3 = new Habilidade("Patada", 25, 2); // pichu, raichu
	Habilidade A4 = new Habilidade("Chidori", 50, 6); // raichu
	
	Habilidade A5 = new Habilidade("Cuspe", 20, 1); // squirtle, rubbish
	Habilidade A6 = new Habilidade("Enxague", 40, 4); // gyarados, squirtle
	Habilidade A7 = new Habilidade("Jato", 45, 5); // gyarados, squirtle
	Habilidade A8 = new Habilidade("Flash Beam", 60, 7); // gyarados, mewtwo, mew
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
	
	
	private class Ataque extends Event{
		Pokemon atc, def;
		public Ataque (long eventTime, Pokemon atacante, Pokemon atacado ){
			super(eventTime);
			atc = atacante;
			def = atacado;
			
		}		
		public void action(){
			//SE O TIPO DO ATACANTE FOR A FRAQUEZA DO DEFENSOR
			if(atc.pegaTipo().equals(def.pegaFraqueza())){
				
			}
		}
		public String description(){
			return "Fim do turno.";
		}
		
	}
	
	
	
	
	//chamar no final da main(?) ou de algum evento
	public String fimDaBatalha(String Vencedor){
		return "O vencedor da batalha foi: "+Vencedor;
	}
	
	
	
	
	
	
	public static void main(String[] args){
		
		
		
	}

}