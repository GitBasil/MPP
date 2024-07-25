package com.mpp.practice.prob2;

import java.util.List;

/**
 * The Administrators have right to access any accounts's balance. have right to check all employee's financial statue. 
 */
public class Admin {
	
	public static double computeAllEmployeeBlanceSum(List<Employee> employees) {
		// implement by stream api or traditional way by sequence diagram
		return employees.stream().mapToDouble(Employee::computeAllAccountsBlanceSum).sum();
	}
}
