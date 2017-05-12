package simulador;

public class Habilidade {
	private String nome;
	private int dano;
	private int velocidade;
	public Habilidade(String nome, int dano, int velocidade){
		this.nome = nome;
		this.dano = dano;
		this.velocidade = velocidade;
	}
	// maior velocidade mais rapido
	public String pegaNome(){
		return this.nome;
	}
	public int pegaDano(){
		return this.dano;
	}

	public int pegaVelocidade(){
		return this.velocidade;
	}
}