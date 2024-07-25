package prog4_4_soln;

import good.Polygon;

public final class Rectangle extends ClosedCurve implements Polygon {
	private double width; 
	private double length;
	private int numberOfSides = 4;
	public Rectangle(double width,double length) {
		this.width = width;
		this.length = length;
	}
	public double computeArea() {
		return (this.width * this.length);
	}
	public int getNumberOfSides() {
		return this.numberOfSides;
	}
	public double computePerimeter() {
		return 2 * (this.width+this.length);
	}
}
