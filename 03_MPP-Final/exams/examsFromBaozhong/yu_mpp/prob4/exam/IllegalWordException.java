package prob4.exam;

@SuppressWarnings("serial")
public class IllegalWordException extends Exception {
	public IllegalWordException() {
		super();
	}
	public IllegalWordException(String msg) {
		super(msg);
	}
	public IllegalWordException(Throwable t) {
		super(t);
	}
}
