package prog3_4;

public class Triangle {
	private double base;
	private double height;
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public Triangle(double side1,double side2,double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getBase() {
		return this.base;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double computeArea() {
		return 0.5 * this.base * this.height;
	}
	
	public void computeAreaSides() {
		if((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1) {
			double s = (side1 + side2 + side3) / 2;
			double area = Math.sqrt(s * (s - side1) * (s - side2) * (s-side3));
			System.out.println("Area of Triangle For 3 Side is: " + area);    
		} else {  
			System.out.println("Area of Triangle not exit");
		}
	}
}
