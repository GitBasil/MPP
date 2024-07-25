package lesson5.lecture.intfaces2;

public class Ellipse implements ClosedCurve {
	private double semiMajorAxis;
	private double semiMinorAxis;

	public Ellipse(double semiMajorAxis, double semiMinorAxis) {
		this.semiMajorAxis = semiMajorAxis;
		this.semiMinorAxis = semiMinorAxis;
	}

	public double getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public void setSemiMajorAxis(double semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	public double getSemiMinorAxis() {
		return semiMinorAxis;
	}

	public void setSemiMinorAxis(double semiMinorAxis) {
		this.semiMinorAxis = semiMinorAxis;
	}

	@Override
	public double computePerimeter() {
		// Ramanujan's approximation for the perimeter of an ellipse
		return Math.PI * (3 * (semiMajorAxis + semiMinorAxis) - 
			Math.sqrt((3 * semiMajorAxis + semiMinorAxis) * (semiMajorAxis + 3 * semiMinorAxis)));
	}
}
