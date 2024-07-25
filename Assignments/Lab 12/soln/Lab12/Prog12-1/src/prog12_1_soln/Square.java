package prog12_1_soln;

public class Square extends ClosedCurve {
	double side;
	public Square(Double side) throws IllegalClosedCurveException {
		//if(side < 0) {
			//throw new IllegalClosedCurveException ("Illegal Side is not positive number!");
		//} else {				
			this(side.doubleValue());
		//}
	}
	public Square(double side) throws IllegalClosedCurveException {
		if(side < 0) {
			throw new IllegalClosedCurveException ("Illegal Side is not positive number!");
		} else {		
			this.side = side;
		}
	}
	double computeArea() {
		return(side*side);
	}
}
