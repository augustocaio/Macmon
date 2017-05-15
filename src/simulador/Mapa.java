package simulador;


public class Mapa extends Controller {
	public int[][] mat = new int[10][10];
	public int tamanho, tamanhox, tamanhoy, nPokeVivos;
	public int inicio, indice;
	Treinador t1, t2;
	Pokemon[] pokemons;
	boolean jalutouselvagem;

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
		jalutouselvagem = false;
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
		boolean jalutou;
		boolean jalutouselvagem;
		
		public Anda(long eventTime, Treinador t, char sent){
			super(eventTime);
			sentido = sent;
			this.t = t;
			confirma = 0;
			jalutou = false;
			
			
		}
		public void action(){
			int xinicial = t.getx();
			int yinicial = t.gety();

			if(sentido == 'w'){
				if(t.y != 0)
					t.y--;
				t.setPos(t.x, t.y);
				confirma = 1;
			}
			if(sentido == 's'){
				if(t.y < getTamanhoy()-1){
					t.y++;
					t.setPos(t.x, t.y);
					confirma = 2;
				}		
			}
			if(sentido == 'd'){
				if(t.x < getTamanhox()-1){
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
			if(confirma != 0){
				if( sentido == 'w' && confirma == 1 )
					System.out.println("O treinador "+t.pegaNome()+" andou para cima\nSua posicao e: ("+t.x+", "+t.y+")\n---------------------------------------");
				else if( sentido == 's' && confirma == 2 )
					System.out.println("O treinador "+t.pegaNome()+" andou para baixo\nSua posicao e: ("+t.x+", "+t.y+")\n---------------------------------------");
				else if (sentido == 'd' && confirma == 3 )
					System.out.println("O treinador "+t.pegaNome()+" andou para a direita\nSua posicao e: ("+t.x+", "+t.y+")\n---------------------------------------");
				else if( sentido == 'a' && confirma == 4 )
					System.out.println("O treinador "+t.pegaNome()+" andou para a esquerda\nSua posicao e: ("+t.x+", "+t.y+")\n---------------------------------------");
				else System.out.println( "Deu erro no evento" );
				
			}
			else System.out.println("O Treinador nao andou e esta na posicao ("+t.x+", "+t.y+")\n---------------------------------------");
			imprimeMapa();
			
			if(getChance(t.x, t.y) && confirma != 0){
				int r = 0 + (int)(Math.random() * ((11) + 1));
				
				//POE UM POKEMON ALEATORIO ENTRE TODOS QUE EXISTEM 
				Treinador silvestre = new Treinador("Silvestre", true, pokemons , t.x, t.y);
				/*for(int m = 0; m<=11; m++){
					System.out.println("O Pokemon "+pokemons[m].pegaNome()+" de indice "+m+ " e " +pokemons[m].hp+ "HP status " +pokemons[m].status);
				}*/
				silvestre.troca(r);
				silvestre.wild = true;
				System.out.println("O Treinador "+t.pegaNome()+" encontrou um Pokemon selvagem\n---------------------------------------");
				
				Batalha selvagem = new Batalha(t, silvestre );
				while(t.status == true && silvestre.pokemon[0].status == true && jalutouselvagem == false){
					//as escolhas são feitas
					/*for(int m = 0; m<=5; m++){
						System.out.println("O Pokemon "+silvestre.pokemon[m].pegaNome()+" de indice "+m+ " e " +silvestre.pokemon[m].hp+ "HP status " +silvestre.pokemon[m].status);
					}*/
					selvagem.ComputaEscolhas(9, 9);
					selvagem.run();
					selvagem.ComputaEscolhas(10, 10);
					selvagem.run();
					selvagem.ComputaEscolhas(12, 12);
					selvagem.run();
					/*for(int m = 0; m<=5; m++){
						System.out.println("O Pokemon "+t.pokemon[m].pegaNome()+" de indice "+m+ " e " +t.pokemon[m].hp+ "HP status " +t.pokemon[m].status);
					}*/
					break;
				}
				jalutouselvagem = true;
			}
			if(t1.x == t2.x && t1.y == t2.y && t1.status == true && t2.status == true && mat[t1.x][t1.y] != 1 ){
				System.out.println("Os Treinadores "+t1.pegaNome()+" e "+t2.pegaNome()+" comecaram uma batalha\n---------------------------------------");
				/*if(t == t1){
					if(xinicial == t2.x && yinicial == t2.y)
						jalutou = true;
				}
				if(t == t2){
					if(xinicial == t1.x && yinicial == t1.y)
						jalutou = true;
				}*/
				Batalha bat = new Batalha(t1, t2);
				bat.run();
				while(t1.status == true && t2.status == true && jalutou == false){
					//as escolhas são feitas
					bat.ComputaEscolhas(9, 9);
					bat.run();
					bat.ComputaEscolhas(10, 10);
					bat.run();
					bat.ComputaEscolhas(12, 12);
					bat.run();
					if(t1.status == false || t2.status == false)			
						break;
				}
				jalutou = true;
				
			}
			t1.status = true;
			t2.status = true;
			
			resetPokemon();
		}
		
		public String description(){
			return "";
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
		System.out.print("Mapa esquematizado, t sao os treinadores e 1 eh onde ha grama\n---------------------------------------\n");
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
		//System.out.println("Numero randomico:"+r+"\n---------------------------------------");
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
	
	void resetPokemon(){
		for(int m = 0; m<=11; m++){
			pokemons[m].hp = 100;
			pokemons[m].status = true;
		}
	}

}
