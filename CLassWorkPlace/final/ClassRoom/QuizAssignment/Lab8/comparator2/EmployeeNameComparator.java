package comparator2;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		int c1 = e1.name.compareTo(e2.name);
		if(c1 != 0) return c1;

		EmployeeSalaryComparator salaryComp = new EmployeeSalaryComparator();
		return salaryComp.compare(e1, e2);
	}
}
