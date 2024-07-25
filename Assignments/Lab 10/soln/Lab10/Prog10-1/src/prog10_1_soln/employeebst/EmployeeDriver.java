package prog10_1_soln.employeebst;

import prog10_1_soln.bst.EmployeeBST;

public class EmployeeDriver {

	public static void main(String[] args) {
		new EmployeeDriver();

	}
	public EmployeeDriver() {
		NameComparator nameComp = new NameComparator();
		/* uncomment when you have created EmployeeBST*/
		EmployeeBST bst = new EmployeeBST(nameComp);
		bst.insert(new Employee("George", 40000, 1996,11,5));
		bst.insert(new Employee("Dave", 50000, 2000, 1, 3));
		bst.insert(new Employee("Sally", 45000, 2001, 2, 7));
		bst.insert(new Employee("Richard", 80000, 1986,3,23));
		bst.printTree();
	}
}
