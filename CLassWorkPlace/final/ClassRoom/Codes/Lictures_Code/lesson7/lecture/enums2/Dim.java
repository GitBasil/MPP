package lesson7.lecture.enums2;

public enum Dim {
	LENGTH(1.0),
	WIDTH(2.0);
	double val;
	Dim(double val){
		this.val=val;
	}
	public double val() {
		return val;
	}
}
