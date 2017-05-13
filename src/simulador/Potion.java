package simulador;

public class Potion extends Item {
	private String nome;
	int qtd;
	private String tipo;
	private int efeito;
	public Potion( String nome, int qtd, int efeito){
		this.nome = nome;
		this.qtd = qtd;
		this.efeito = efeito;
	}
	public String pegaTipo(){
		return this.tipo;
	}
	public int pegaEfeito(){
		return this.efeito;
	}	
	public String pegaNome() {
		return this.nome;
	}
}
