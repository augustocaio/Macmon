package simulador;

public class Pokemon {
	private String nome;
	public int hp;
	private String tipo;
	private Ataque[] ataque = new Ataque[4];
	private String fraqueza;
	public boolean status;
	
	//ou vetor com 4 nome de ataques e outro com int dos repectivos danos pra cada pokemon
	//ou usar classe ataque
	
	
	public Pokemon(String nome, int hp, String tipo, String fraqueza, Ataque a1, Ataque a2, Ataque a3, Ataque a4){
		this.nome = nome;
		this.hp = hp;
		this.tipo = tipo;
		this.ataque[0] = a1;
		this.ataque[1] = a2;
		this.ataque[2] = a3;
		this.ataque[3] = a4;
		this.fraqueza = fraqueza;
		this.status = true;
	}
	public String pegaNome(){
		return this.nome;
	}
	public int pegaHP(){
		return this.hp;
	}
	public String pegaTipo(){
		return this.tipo;
	}
	public String pegaFraqueza(){
		return this.fraqueza;
	}
	public Ataque pegaAtaque(int i){
		return this.ataque[i];
	}
}
