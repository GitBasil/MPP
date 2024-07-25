package prog3_4;

public class Circle {
	private final double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double computeArea() {
		return Math.pow(this.radius, 2) * Math.PI;
	}
}
