package simulador;

public class Pokemon {
	private String nome;
	public int hp;
	private String tipo;
<<<<<<< HEAD
	private String[] ataques = new String[4];
=======
	private Ataque[] ataques = new Ataque[4];
	private String fraqueza;
	public boolean vivo;
	
>>>>>>> caio
	//ou vetor com 4 nome de ataques e outro com int dos repectivos danos pra cada pokemon
	//ou usar classe ataque
	
	
<<<<<<< HEAD
	public Pokemon(String nome, int hp, String tipo, String ataques[]){
=======
	public Pokemon(String nome, int hp, String tipo, Ataque ataques[], String fraqueza){
>>>>>>> caio
		this.nome = nome;
		this.hp = hp;
		this.tipo = tipo;
		this.ataques = ataques;
<<<<<<< HEAD
=======
		this.fraqueza = fraqueza;
		this.vivo = true;
>>>>>>> caio
	}
}
