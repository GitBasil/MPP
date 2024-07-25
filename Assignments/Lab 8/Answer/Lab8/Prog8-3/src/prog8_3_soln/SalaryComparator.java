package prog8_3_soln;

import java.util.Comparator;

import prog8_3_soln.employeesort.Employee;

public class SalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1,Employee e2) {
		if(e1.getSalary() < e2.getSalary()) return -1;
		else if(e1.getSalary() > e2.getSalary()) return 1;
		return 0;
	}
}
