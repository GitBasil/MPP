package prog4_2_soln;

public final class Rectangle extends ClosedCurve {
	private double width; 
	private double length;
	public Rectangle(double width,double length) {
		this.width = width;
		this.length = length;
	}
	public double computeArea() {
		return (this.width * this.length);
	}
}
