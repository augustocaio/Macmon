package simulador;

public class Treinador {
	public Pokemon[] pokemon = new Pokemon[6];
	private String nome;
	public boolean status;
	public String movimento;
	public boolean wild;
	Item itens[];
	
	public Treinador( String nome, boolean selvagem, Pokemon[] pok, Item[] itens){
		this.nome = nome;
		this.pokemon[0] = pok[0];
		this.pokemon[1] = pok[1];
		this.pokemon[2] = pok[2];
		this.pokemon[3] = pok[3];
		this.pokemon[4] = pok[4];
		this.pokemon[5] = pok[5];
		this.status = true;
		wild = selvagem;
		this.itens = itens;
	}
	public Treinador( Pokemon p1) {
		this.pokemon[0] = p1;
		this.status = true;
	}
	
	String pegaNome(){
		return this.nome;
	}
	public void curar(Potion a){
		if(this.pokemon[0].hp>=100){
			this.pokemon[0].hp = 100;
			//System.out.println("O pokemon "+this.pokemon[0].pegaNome()+" foi curado em "+a.pegaNome()+ " em "+a.pegaEfeito()+ "hp e tem agora " +this.pokemon[0].pegaHP() +"HP");
		} else {
			if(this.pokemon[0].hp>0 && this.pokemon[0].hp <=100){
			this.pokemon[0].hp+= a.pegaEfeito();
			if(this.pokemon[0].hp >= 100) {
				this.pokemon[0].hp = 100;
			}
			//System.out.println("O pokemon "+this.pokemon[0].pegaNome()+" foi curado com "+a.pegaNome()+ " em "+a.pegaEfeito()+"hp e tem agora " +this.pokemon[0].pegaHP() +"HP");
		}
		}
	}
	public void corre(){
		status = false;
		System.out.println("O treinador "+pegaNome()+" fugiu, perdendo a batalha.");
	}
	public void troca(int i){
		Pokemon aux = this.pokemon[0];
		int k = i ;
		System.out.println("Antes");
		for(int m = 0; m<5; m++){
			System.out.println("O Pokemon "+pokemon[m].pegaNome()+" de indice "+m+ " e " +pokemon[m].hp+ "HP status " +pokemon[m].status);
		}
		while(k<6){
			if(pokemon[k].status ==  true && pokemon[k]!=null){
				pokemon[0] = pokemon[k];
				pokemon[k] = aux;
				break;
			}
			k++;
		}
		System.out.println("Depois");
		for(int m = 0; m<5; m++){
			System.out.println("O Pokemon "+pokemon[m].pegaNome()+" de indice "+m+ " e " +pokemon[m].hp+ "HP status " +pokemon[m].status);
		}
		//if(k!=0 && k<=5)
			//System.out.println(aux.pegaNome()+" foi substituido por "+pokemon[0].pegaNome());
		if(k>=5 && pokemon[0].status == false){
			status = false;
			//System.out.println("O treinador "+pegaNome()+" perdeu a batalha por nao possuir mais pokemons para combate");
		}
		System.out.println("\n---------------------------------------");
	}
	
}