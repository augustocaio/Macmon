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
		//if numero de pokemon for 1 e o hp for zero, o treinador perdeu MAS MAIS FACIL FAZER ISSO NA BATALHA
		//if numero de pokemon for 1 e o treinador tentar trocar nao funciona
		/*Pokemon Z = new Pokemon();
		Z = A;
		A = B;
		B = Z;
		Z = null;*/
	}
	void usarItem(Pokemon A){
		A.hp = 100;
		/*if( A.hp > 100){
			A.hp = 100;
		}*/
		//hp max
	}
}
