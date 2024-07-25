package prob2;

import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * The Administrators have right to access any accounts's balance. have right to check all employee's financial statue. 
 */
public class Admin {
	
	public static <T> double computeAllEmployeeBlanceSum(List<Employee> employees) {
		// implement by stream api or traditional way by sequence diagram
		
		ToDoubleFunction<Employee> tf = Employee::computeAllAccountsBlanceSum;

		return employees.stream().mapToDouble(Employee::computeAllAccountsBlanceSum).sum();
	}
}
