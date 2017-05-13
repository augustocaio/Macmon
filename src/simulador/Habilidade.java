package simulador;

public class Habilidade {
	private String nome;
	public double dano;
	private int velocidade;
	public Habilidade(String nome, double dano, int velocidade){
		this.nome = nome;
		this.dano = dano;
		this.velocidade = velocidade;
	}
	// maior velocidade mais rapido
	public String pegaNome(){
		return this.nome;
	}
	public double pegaDano(){
		return this.dano;
	}
<<<<<<< HEAD
=======
	
	public void setDano(double d){
		this.dano = d;
	}
>>>>>>> jun

	public int pegaVelocidade(){
		return this.velocidade;
	}
}