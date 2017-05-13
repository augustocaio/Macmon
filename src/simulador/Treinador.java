package simulador;

public class Treinador {
	public Pokemon[] pokemon = new Pokemon[6];
	private String nome;
	public boolean status;
	public String movimento;
	
	public Treinador( String nome, Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4, Pokemon p5, Pokemon p6){
		this.nome = nome;
		this.pokemon[0] = p1;
		this.pokemon[1] = p2;
		this.pokemon[2] = p3;
		this.pokemon[3] = p4;
		this.pokemon[4] = p5;
		this.pokemon[5] = p6;
		this.status = true;
	}
	String pegaNome(){
		return this.nome;
	}
	public void curar(Potion a){
		if(this.pokemon[0].hp>0){
			this.pokemon[0].hp+= a.pegaEfeito();
		}
		if(this.pokemon[0].hp>=100){
			this.pokemon[0].hp = 100;
		}
	}
	public void corre(){
		status = false;
		System.out.println("O treinador "+pegaNome()+" fugiu, perdendo a batalha.");
	}
	public void troca(int i){
		Pokemon aux = this.pokemon[0];
		int k = i ;
		while(k<5){
			this.pokemon[0] = pokemon[k];
			if(pokemon[0].status ==  true){
				pokemon[k] = pokemon[0];
				break;
			}
			k++;
		}
		if(k!=0)
			System.out.println(aux.pegaNome()+" foi substituido por "+pokemon[0].pegaNome());
		if(k>=5){
			status = false;
			System.out.println("O treinador "+pegaNome()+" perdeu a batalha.");
		}
	}
	
}