package prog12_2_soln;

public class OverdrawnAccountException extends Exception {
	public OverdrawnAccountException() {
		super();
	}
	public OverdrawnAccountException(String msg) {
		super(msg);
	}
	public OverdrawnAccountException(Throwable t) {
		super(t);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
