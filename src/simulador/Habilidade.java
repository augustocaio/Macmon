package simulador;

public class Habilidade {

	private String nome;
	private int dano;
	private int tempo;
	public Habilidade(String nome, int dano, int tempo){
		this.nome = nome;
		this.dano = dano;
		this.tempo = tempo;
	}
	// menor velocidade mais rapido
	public String pegaNome(){
		return this.nome;
	}
	public int pegaDano(){
		return this.dano;
	}
	public int pegaTempo(){
		return this.tempo;
	}
}
