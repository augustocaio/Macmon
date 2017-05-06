package simulador;

public class Batalha extends Controller{
	private String status = "ativo";
	
	public Batalha() {}
	
	private class Turno extends Event{
		public Turno (long eventTime){
			super(eventTime);
		}
		
		public void action(){
			while(status == "ativo"){
				
				// oq falta: opcoes -> fugir - trocar pokemon - item - atacar
				
				
				//se todos os pokemons de um usurario morreram status = inativo
				
				//if pro item: se hp é 0 nao da pra usar o item, usar o boolean de pokemon vivo
				
				//if para se o pokemon morrer, trocar o pokemon e quando atacar e ofor  hp 0 ou menor que zero ele fica morto
				if( status == "inativo"){
					fimDaBatalha();
					break;
				}
			}
		}
		public String description(){
			return "TURNO EM QUE OCORRE AS ACOES DOS JOGADORES";
		}
		
	}
	
	public String fimDaBatalha(){
		return "vencedor";
	}
	public static void main(String[] args){
		Ataque A1 = new Ataque("Trovom", 35, 4); // pichu, raichu
		Ataque A2 = new Ataque("Rabada", 40, 5); // pichu, raichu, gyarados, 
		// mew, mewtwo, arboc, squirtle, charmander
		
		Ataque A3 = new Ataque("Patada", 25, 2); // pichu, raichu
		Ataque A4 = new Ataque("Chidori", 50, 6); // pichu, raichu
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
		
		Ataque A20 = new Ataque("");
		Ataque A21 = new Ataque("");
		Ataque A22 = new Ataque("");
		
		
		
		
		Pokemon P1 = new Pokemon("Gyarados", 100, "agua", , "raio");
		Pokemon P2 = new Pokemon("Squirtle", 100, "agua");
		
		Pokemon P3 = new Pokemon("Raichu", 100, "raio", "terra");
		Pokemon P4 = new Pokemon("Pichu", 100, "raio", "terra");
		
		Pokemon P5 = new Pokemon("Mew", 100, "psico", "dark");
		Pokemon P6 = new Pokemon("MewTwo", 100, "psico", "dark");
		
		Pokemon P7 = new Pokemon("Rolezera", 100, "dark", "psico");//curtissaum, ficar, ideia errada, sacrificar
		Pokemon P8 = new Pokemon("Gato do Role", 100, "dark", "psico");//brutos, chega bejando, xaveco, enaltecer
		
		Pokemon P9 = new Pokemon("Dragonite", 100, "dragao", , "veneno");
		Pokemon P10 = new Pokemon("Charmander", 100, "fogo", "agua");
		Pokemon P11 = new Pokemon("Arboc", 100, "veneno", "dragao");
		Pokemon P12 = new Pokemon("Rubbish", 100, "terra", "agua");
		
		Treinador t1 = new Treinador(Trash, );
		Treinador t2 = new Treinador(Dusty, );
	}

}
