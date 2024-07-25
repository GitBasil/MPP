package prob2;

import java.util.ArrayList;
import java.util.List;

/**
 * Add code by class diagram. 
 *
 */
public class Employee {
	private String name;
	private int age;
	private List<Account> accounts = new ArrayList();
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public double computeAllAccountsBlanceSum() {
		// implement by stream api or traditional way by sequence diagram
		return accounts.stream().mapToDouble(Account::computeBalance).sum();
	}
}
