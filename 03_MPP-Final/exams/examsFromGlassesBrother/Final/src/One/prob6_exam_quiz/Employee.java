package One.prob6_exam_quiz;


public class Employee extends Person {
	int salary;
	public Employee(String n, int s) {
		super(n);
		this.salary = s;
	}
	int getSalary() {
		return salary;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(getName());
		sb.append(" salary: ");
		sb.append("" + salary+">");
		return sb.toString();
		
	}
}

