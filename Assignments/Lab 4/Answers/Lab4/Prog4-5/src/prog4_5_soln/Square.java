package prog4_5_soln;

import good.Polygon;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	private int numberOfSides = 4;
	public Square(double side){
		this.side = side;
	}
	public double computeArea() {
		return side * side;
	}
	public int getNumberOfSides() {
		return this.numberOfSides;
	}
	/*public double computePerimeter() {
		return 4 * this.side;
	}*/
	public double[] getArrayOfSides() {
		double[] sides = {this.side,this.side,this.side,this.side};
		return sides;
	}	
}
