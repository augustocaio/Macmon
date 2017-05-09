package simulador;

public class Pokemon {
	private String nome;
	public int hp;
	private String tipo;
	private Ataque[] ataques = new Ataque[4];
	private String fraqueza;
	public boolean vivo;
	
	//ou vetor com 4 nome de ataques e outro com int dos repectivos danos pra cada pokemon
	//ou usar classe ataque
	
	
	public Pokemon(String nome, int hp, String tipo, String fraqueza, Ataque a1, Ataque a2, Ataque a3, Ataque a4){
		this.nome = nome;
		this.hp = hp;
		this.tipo = tipo;
		this.ataques[0] = a1;
		this.ataques[1] = a2;
		this.ataques[2] = a3;
		this.ataques[3] = a4;
		this.fraqueza = fraqueza;
		this.vivo = true;
	}
}
