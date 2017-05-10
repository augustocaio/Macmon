package simulador;

public class Pokemon {
	private String nome;
	public int hp;
	private String tipo;
	private Habilidade[] ataque = new Habilidade[4];
	private String fraqueza;
	public boolean status;
	
	//ou vetor com 4 nome de ataques e outro com int dos repectivos danos pra cada pokemon
	//ou usar classe ataque
	
	
	public Pokemon(String nome, int hp, String tipo, String fraqueza, Habilidade a1, Habilidade a2, Habilidade a3, Habilidade a4){
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
	//os seguintes metodos retornam as variaveis de tipo privado
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
	public Habilidade pegaAtaque(int i){
		return this.ataque[i];
	}
}
