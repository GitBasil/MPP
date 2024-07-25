package prog12_1_soln;

@SuppressWarnings("serial")
public class IllegalClosedCurveException extends Exception {
	public IllegalClosedCurveException() {
		super();
	}
	public IllegalClosedCurveException(String msg) {
		super(msg);
	}
	public IllegalClosedCurveException(Throwable t) {
		super(t);
	}
}
