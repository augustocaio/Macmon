package simulador;

public class Habilidade {

	private String nome;
	private int dano;
<<<<<<< HEAD
	private int tempo;
	public Habilidade(String nome, int dano, int tempo){
		this.nome = nome;
		this.dano = dano;
		this.tempo = tempo;
	}
	// menor velocidade mais rapido
=======
	private int velocidade;
	public Habilidade(String nome, int dano, int velocidade){
		this.nome = nome;
		this.dano = dano;
		this.velocidade = velocidade;
	}
	// maior velocidade mais rapido
>>>>>>> master
	public String pegaNome(){
		return this.nome;
	}
	public int pegaDano(){
		return this.dano;
	}
<<<<<<< HEAD
	public int pegaTempo(){
		return this.tempo;
	}
}
=======
	public int pegaVelocidade(){
		return this.velocidade;
	}
}
>>>>>>> master
