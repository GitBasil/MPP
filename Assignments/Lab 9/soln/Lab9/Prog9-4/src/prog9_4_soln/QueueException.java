package prog9_4_soln;

@SuppressWarnings("serial")
public class QueueException extends Exception {
	public QueueException() {
		super();
	}
	public QueueException(String msg) {
		super(msg);
	}
	public QueueException(Throwable t) { 
		super(t);
	}
}
