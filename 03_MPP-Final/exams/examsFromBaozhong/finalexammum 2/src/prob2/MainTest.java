package prob2;

import java.util.Arrays;
import java.util.List;

public class MainTest {
	public static void main(String[] args) {
		Account ca1 = new CheckingAccount("344-566", 1000, 0.003);
		Account ca2 = new CheckingAccount("344-896", 1500, 0.025);
		Account ca3 = new CheckingAccount("344-096", 2000, 0.018);
		
		Account sa1 = new SavingAccount("688-878", 1000, 25);
		Account sa2 = new SavingAccount("688-428", 1000, 25);
		Account sa3 = new SavingAccount("688-856", 2000, 25);
		
		Employee employee1 = new Employee("Samuel", 21);
		Employee employee2 = new Employee("Bob", 51);
		Employee employee3 = new Employee("Trump", 78);
		Employee employee4 = new Employee("Obama", 43);
		
		employee1.addAccount(ca1);
		employee1.addAccount(sa1);
		employee1.addAccount(sa2);

		employee2.addAccount(ca2);
		employee2.addAccount(ca3);
		employee2.addAccount(sa3);
		
		employee3.addAccount(sa2);
		employee3.addAccount(ca2);
		
		employee4.addAccount(sa1);
		
		List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4);
		
		// Questions 2:
		// implement all classes by class diagram.
		// implement 'computeAllEmployeeBlanceSum' method in Admin by sequence dialog
		// 'computeAllEmployeeBlanceSum' will need every account's computed balance. 
		double sum = Admin.computeAllEmployeeBlanceSum(employees);
		System.out.println("Test sum = " + sum);
	}
}
