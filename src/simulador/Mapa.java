package simulador;


public class Mapa extends Controller {
	public int[][] mat = new int[10][10];
	public int tamanho, tamanhox, tamanhoy, nPokeVivos;
	public int inicio, indice;
	Treinador t1, t2;
	Pokemon[] pokemons;
	// tWild seria o treinador q a gente criaria pra ter apenas 1 pokemon, o pokemon selvagem
	// t1 provavelmente seria o treinador q a gente "controla" e t2 seria o treinador q batalha com t1
	// "controla": ele que batalha com os pokemons selvagens
	// nPokeVivos: numero de pokemons vivos do treinador que anda pelo mato
	
	public Mapa(int tamanho, Treinador t1, Treinador t2, Pokemon[] pokemons) {
		//sera quadrada
		this.tamanhox = tamanho;
		this.tamanhoy = tamanho;
		this.tamanho = tamanho;
		this.t1 = t1;
		this.t2 = t2;
		this.pokemons = pokemons;
		this.poeGrama(tamanho);
	}
	// mapa unidirecional: em x
	// dois treinadores q podem batalhar entre si se estiverem no mesmo indice e fora da grama
	// pokemons selvagens podem aparecer apenas na grana

	// 6 - EVENTO DE ANDAR
	public class Anda extends Event{
		Treinador t;
		char sentido;
		Mapa mapa;
		int confirma;
		
		public Anda(long eventTime, Treinador t, char sent){
			super(eventTime);
			sentido = sent;
			this.t = t;
			this.mapa = mapa;
			confirma = 0;
			
		}
		public void action(){
			if(sentido == 'w'){
				if(t.y != 0)
					t.y--;
				t.setPos(t.x, t.y);
				confirma = 1;
			}
			if(sentido == 's'){
				if(t.y < mapa.getTamanhoy()-1){
					t.y++;
					t.setPos(t.x, t.y);
					confirma = 2;
				}		
			}
			if(sentido == 'd'){
				if(t.x < mapa.getTamanhox()-1){
					t.x++;
					t.setPos(t.x, t.y);
					confirma = 3;
				}
			}
			if(sentido == 'a'){
				if(t.x != 0)
					t.x--;
					t.setPos(t.x, t.y);
					confirma = 4;
			}
			imprimeMapa();
			if(mapa.getChance(t.x, t.y) && confirma != 0){
				int r = 0 + (int)(Math.random() * ((11) + 1));
				
				//POE UM POKEMON ALEATORIO ENTRE TODOS QUE EXISTEM 
				Treinador silvestre = new Treinador(" Silvestre", true, pokemons , t.x, t.y);
				silvestre.troca(r);
				silvestre.wild = true;
				
				Batalha selvagem = new Batalha(t1, silvestre );
				while(t1.status == true && silvestre.status == true){
					//as escolhas são feitas
					selvagem.ComputaEscolhas(9, 9);
					selvagem.run();
					selvagem.ComputaEscolhas(10, 10);
					selvagem.run();
					selvagem.ComputaEscolhas(12, 12);
					selvagem.run();
				}
			}
			if(t1.pos == t2.pos && t1.status == true && t2.status == true){
				Batalha bat = new Batalha(t1, t2);
				bat.run();
				while(t1.status == true && t2.status == true){
					//as escolhas são feitas
					bat.ComputaEscolhas(9, 9);
					bat.run();
					bat.ComputaEscolhas(10, 10);
					bat.run();
					bat.ComputaEscolhas(12, 12);
					bat.run();
				}
				t1.status = true;
				t2.status = true;
			}
		}
		
		public String description(){
			if(confirma != 0){
				if( sentido == 'w' && confirma == 1 )
					return "O treinador "+t.pegaNome()+" andou para cima\n Sua posicao e ("+t.x+", "+t.y+")\n---------------------------------------";
				else if( sentido == 's' && confirma == 2 )
					return "O treinador "+t.pegaNome()+" andou para baixo\n Sua posicao e ("+t.x+", "+t.y+")\n---------------------------------------";
				else if (sentido == 'd' && confirma == 3 )
					return "O treinador "+t.pegaNome()+" andou para a direita\n Sua posicao e ("+t.x+", "+t.y+")\n---------------------------------------";
				else if( sentido == 'a' && confirma == 4 )
					return "O treinador "+t.pegaNome()+" andou para a esquerda\n Sua posicao e ("+t.x+", "+t.y+")\n---------------------------------------";
				else return "Deu erro no evento";
				
			}
			else return "O Treinador nao andou e esta na posicao ("+t.x+", "+t.y+")\n---------------------------------------";
		}
	}
	public void poeGrama(int tam) {
		int i = 0, j = 0;
		for(i = 0; i < tam; i++){
			for(j = 0; j < tam; j++){
				if(i == j){
					mat[i][j] = 1;
				}
				else mat[i][j] = 0;
			}
		}

		/*for( i =0; i < tamanho; i++){
            for( j =0; j < tamanho; j++){
                System.out.print(mapa [i] [j]+ " ");
            }
        System.out.println();
        }*/
		imprimeMapa();
	}
	
	public void imprimeMapa(){
		int i =0, j = 0;
		System.out.print("\n---------------------------------------\n");
		for( j =0; j < tamanho; j++){
            for( i =0; i < tamanho; i++){
            	if(i == t1.x && j == t1.y){
            		System.out.print("t1 ");
            	}
            	if(i == t2.x && j == t2.y){
            		System.out.print("t2 ");
            	}
            	if((i != t2.x || j != t2.y) && (i != t1.x || j != t1.y))
            		System.out.print(mat [i] [j]+ " ");
            }
            System.out.print("\n");
		}
		System.out.print("\n---------------------------------------\n");
		
	}
	
	public int getTamanhox() {
		return this.tamanhox;
	}
	public int getTamanhoy() {
		return this.tamanhoy;
	}
	
	public void setTamanhox(int t) {
		this.tamanhox = t;
	}
	public void setTamanhoy(int t) {
		this.tamanhoy = t;
	}
	
	public void setPokeVivos(int pv) {
		this.nPokeVivos = pv;
	}
	public int getPokeVivos() {
		return this.nPokeVivos;
	}
	

	public boolean getChance(int i, int j){
		int r = (int) (Math.random() * 100);
		if(mat[i][j] == 1){
			if(r>50)
				return false;
			else
				return true;
		}
		else return false;
		
	}
	void walk(Treinador t, char way){
		addEvent( new Anda(System.currentTimeMillis(),  t, way));
		run();
	}
	

}
