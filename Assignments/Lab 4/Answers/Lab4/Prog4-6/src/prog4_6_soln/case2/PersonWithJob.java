package prog4_6_soln.case2;
import java.util.GregorianCalendar;
public final class PersonWithJob extends Person {
	private double salary;
	final double THRESHOLD = .0001;
	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		super(name, dob);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	
	@Override
	public final boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)ob;
		return p.getName().equals(this.getName()) && 
			   p.getDateOfBirth().equals(this.getDateOfBirth()) && 
			   (Math.abs(p.getSalary() - this.salary) < THRESHOLD);
	}
}
