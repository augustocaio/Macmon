package simulador;

public class Treinador {
	public Pokemon[] pokemon = new Pokemon[6];
	private String nome;
	
	public Treinador( String nome, Pokemon pokemon[]){
		this.nome = nome;
		this.pokemon = pokemon;
	}
	
	void fugir(){
		//acaba batalha e treinador oposto vence
	}
	Ataque escolheAtaque(Pokemon A){
		// treinador escolhe um ataque entre os 4 ataques do pokemao A
		//MUDAR PROXIMA LINHA DO RETURN
		return null;
	}
	void trocar(Pokemon A, Pokemon B){
		/*Pokemon Z = new Pokemon();
		Z = A;
		A = B;
		B = Z;
		Z = null;
		*/
	}
	void usaritem(Pokemon A){
		A.hp=100;
		//hp max
	}
}
