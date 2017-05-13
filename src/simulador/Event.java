package simulador;
abstract public class Event {
	private long evtTime;
	public Event(long eventTime) { 
	evtTime = eventTime;
	}
	public boolean ready() {
		return System.currentTimeMillis() >= evtTime; //quando for a hora do evento retorna true
	}
	abstract public void action();
	abstract public String description();
}
