package simulador;

public abstract class Evento {
	private long tempoev;
	public Evento(long tempoev) {
		this.tempoev = tempoev;
	}
	public boolean pronto() {
		return System.currentTimeMillis() >= this.tempoev;
	}
	abstract public void acao();
	abstract public String descricao();
}
