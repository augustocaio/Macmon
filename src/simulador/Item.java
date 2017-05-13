package simulador;

public class Item {
	private String nome;
	int qtd;
	private String tipo;
	private int efeito;
	public Item( ){
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
