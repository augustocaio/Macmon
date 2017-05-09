package simulador;

public class Treinador {
	public Pokemon[] pokemon = new Pokemon[6];
	private String nome;
	public boolean status;
	
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
	String rtNome(){
		return this.nome;
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
