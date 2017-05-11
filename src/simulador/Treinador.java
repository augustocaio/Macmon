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
	
}