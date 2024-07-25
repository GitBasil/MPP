package prog4_6_soln.case3;
import java.util.GregorianCalendar;
public class PersonWithJob {
	private double salary;
	final double THRESHOLD = .0001;
	private Person person;
	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		person = new Person(name, dob);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public String getName() {
		return person.getName();
	}
	public GregorianCalendar getDateOfBirth() {
		return person.getDateOfBirth();
	}
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)ob;
		return p.getName().equals(this.getName()) && 
			   p.getDateOfBirth().equals(this.getDateOfBirth()) && 
			   (Math.abs(p.getSalary() - this.salary) < THRESHOLD);
	}
}
