package simulador;

public class Pokemon {
	private String nome;
	public int hp;
	private String tipo;
	private Ataque[] ataques = new Ataque[4];
	
	//ou vetor com 4 nome de ataques e outro com int dos repectivos danos pra cada pokemon
	//ou usar classe ataque
	
	
	public Pokemon(String nome, int hp, String tipo, Ataque ataques[]){
		this.nome = nome;
		this.hp = hp;
		this.tipo = tipo;
		this.ataques = ataques;
	}
}
