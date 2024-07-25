package prog3_4;

public class Main {

	public static void main(String[] args) {
		Triangle triArea = new Triangle(34.75, 2);
		System.out.println("Area of Triangle is "+triArea.computeArea());
		
		Triangle triArea2 = new Triangle(10,10,10);
		triArea2.computeAreaSides();
		
		Rectangle rectangleArea = new Rectangle(9,4);
		System.out.println("Area of Rectangle is "+rectangleArea.computeArea());
		
		Circle circleArea = new Circle(4.32);
		System.out.println("Area of Circle is "+circleArea.computeArea());
	}

}
