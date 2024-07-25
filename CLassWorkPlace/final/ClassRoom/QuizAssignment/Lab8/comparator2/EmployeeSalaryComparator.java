package comparator2;


import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		int c1;
		if(e1.salary == e2.salary) c1= 0;
		else if(e1.salary < e2.salary) c1= -1;
		else c1= 1;

		if(c1 != 0) return c1;

		EmployeeNameComparator nameComp = new EmployeeNameComparator();
		return nameComp.compare(e1, e2);
	}
}
