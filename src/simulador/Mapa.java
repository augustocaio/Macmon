package simulador;

import java.util.Random;

public class Mapa extends Controller {
	private boolean[] mapa;
	private int tamanho, nPokeVivos;
	public int inicio, indice;
	Treinador t1, t2, twild;
	// tWild seria o treinador q a gente criaria pra ter apenas 1 pokemon, o pokemon selvagem
	// t1 provavelmente seria o treinador q a gente "controla" e t2 seria o treinador q batalha com t1
	// "controla": ele que batalha com os pokemons selvagens
	// nPokeVivos: numero de pokemons vivos do treinador que anda pelo mato
	
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
			// tudo menos o ultimo quadrado é grama
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
			// 70%, sei lá, de chance de batalha com poke selvagem
			if(ehGrama(indice) && v<8) {
				// criar lista de pokemons selvagens? provavelmente sim
				// acho q um if usando o "v" para lutar com um pokemon selvagem aleatorio
				
				// batalha
			}
			
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
