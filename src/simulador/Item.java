package simulador;

public class Item {
	private String nome;
	int qtd;
	private String tipo;
	public Item(String nome, int qtd, String tipo ){
		this.nome = nome;
		this.qtd = qtd;
		this.tipo = tipo;
	}
	public String pegaTipo(){
		return this.tipo;
	}
	
	public String pegaNome() {
		return this.nome;
	}
}
