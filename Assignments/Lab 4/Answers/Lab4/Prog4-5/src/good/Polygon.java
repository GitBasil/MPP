package good;

public interface Polygon {
	//public int getNumberOfSides();
	//public double computePerimeter();
	//returns in an array all sides of the polygon
	//example: For a rectangle, return would be [width, width,length, length]
	public double[] getArrayOfSides();
	//returns the sum of the values in arr
	static double sum(double[] arr) {
		double sum = 0;
		for(double d: arr) {
			sum += d;
		}
		return sum;
	}
	//returns the perimeter of the polygon
	default double computePerimeter() {
		double[] sides = this.getArrayOfSides(); 
		return sum(sides);
	}
}
