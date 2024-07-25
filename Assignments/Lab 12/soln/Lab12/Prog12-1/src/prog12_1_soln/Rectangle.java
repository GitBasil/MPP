package prog12_1_soln;

public class Rectangle extends ClosedCurve {
	private double width;
	private double length;
	public Rectangle(double width, double length)  throws IllegalClosedCurveException {
		if(width < 0 || length < 0) {
			throw new IllegalClosedCurveException ("Illegal width and length is not positive number!");
		} else {
			this.length = length;
			this.width = width;
		}
	}
	double computeArea() {
		return width*length;
	}
}