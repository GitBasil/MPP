package prob1;

public class Student {
	private String name;
	private double gpa;
	private String major;
	
	public Student(String name, double gpa, String major) {
		super();
		this.name = name;
		this.gpa = gpa;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + ", major=" + major + "]";
	}	
}
