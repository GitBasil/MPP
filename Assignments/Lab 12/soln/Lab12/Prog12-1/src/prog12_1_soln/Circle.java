package prog12_1_soln;
//import java.util.logging.*;

public class Circle extends ClosedCurve {
	double radius;
	//private static final Logger LOG = Logger.getLogger(CallingClass.class.getPackage().toString());
	public Circle(Double radius)  throws IllegalClosedCurveException {
		this(radius.doubleValue());
	}
	public Circle(double radius) throws IllegalClosedCurveException {
		if(radius < 0) {
			//log.warning ("Illegal radius is not positive number!");
			throw new IllegalClosedCurveException ("Illegal radius is not positive number!");
		} else {
			this.radius = radius;
		}
	}
	double computeArea() {
		return (Math.PI * radius * radius);
	}
}
