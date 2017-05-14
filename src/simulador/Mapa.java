package simulador;

import java.util.Random;

public class Mapa extends Controller {
	private boolean[] mapa;
	private int tamanho, nPokeVivos;
	public int inicio, indice;
	Treinador twild;
	// tWild seria o treinador q a gente criaria pra ter apenas 1 pokemon, o pokemon selvagem
	// t1 provavelmente seria o treinador q a gente "controla" e t2 seria o treinador q batalha com t1
	// "controla": ele que batalha com os pokemons selvagens
	// nPokeVivos: numero de pokemons vivos do treinador que anda pelo mato
	
	
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
	Habilidade A25 = new Habilidade("Lan√ßa-Chamas",         50,        70);
	Habilidade A26 = new Habilidade("Bola de fogo",          45,        75);
	Habilidade A27 = new Habilidade("Toxico",                50,        70);
	Habilidade A28 = new Habilidade("Toxic Spray",           35,        85);
	Habilidade A29 = new Habilidade("Jogar Terra",           25,        95);
														//  dano     velocidade
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
	
	Treinador t1 = new Treinador("Trash", P1, P2, P3, P4, P5, P6);
	Treinador t2 = new Treinador("Dusty", P7, P8, P9, P10, P11, P12);
	
	public Mapa(int t, Treinador t1, Treinador t2) {
		this.tamanho = t;
		this.t1 = t1;
		this.t2 = t2;
		mapa = new boolean[t];
		inicio = 0;
		indice = 0;
	}
	// mapa unidirecional: em x
	// dois treinadores q podem batalhar entre si se estiverem no mesmo indice e fora da grama
	// pokemons selvagens podem aparecer apenas na grana
	
	public boolean ehGrama(int i) {
		if(i<this.tamanho) {
			return mapa[i];
			// tudo menos o ultimo quadrado È grama
		} else {
			return false;
		}
	}

	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public void setTamanho(int t) {
		this.tamanho = t;
	}
	
	public void setPokeVivos(int pv) {
		this.nPokeVivos = pv;
	}
	public int getPokeVivos() {
		return this.nPokeVivos;
	}
	
	private class Andar extends Event {
		public Andar(long evtTime) {
			super(evtTime);
		}

		public void action() {
			Random r = new Random();
			int v = r.nextInt(10);
			// 70%, sei l·, de chance de batalha com poke selvagem
			if(ehGrama(indice) && v<6) {
				if(v == 0) {
					twild = new Treinador(P3);
				}
				if(v == 1) {
					twild = new Treinador(P4);
				}
				if(v == 2) {
					twild = new Treinador(P1);
				}
				if(v == 3) {
					twild = new Treinador(P9);
				}
				if(v == 4) {
					twild = new Treinador(P10);
				}
				if(v == 5) {
					twild = new Treinador(P11);
				}
				Batalha b = new Batalha();
				b.ComputaEscolhas(10, 12);
				// ComputaEscolhas seria pra t1 e t2, talvez bugue para t1 e twild;
				// acho q precisa criar um metodo pra batalha especifica com pokemon selvagem
				// 
			}
			indice++;
			
		}

		public String description() {
			return t1.pegaNome() + "andou pelo indice " + indice + " num" + (ehGrama(indice) ? "a grama" : " chao normal")
					+ "\n---------------------------------------"
					+ t2.pegaNome() + "andou pelo indice " + indice + " num" + (ehGrama(indice) ? "a grama" : " chao normal");
			// mudar isso acho, "andou pelo indice" nao fica mto bom
		}
	}
	
	public static void main(String[] args) {
		
	}

}
