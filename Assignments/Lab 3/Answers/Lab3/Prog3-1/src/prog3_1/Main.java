package prog3_1;

public class Main {

	public static void main(String[] args) {
		Employee employee = new Employee("Mohammed AlDini", "Maldini", 1300, 2016, 6,01);
		/*Then it creates a checking account, 
		 * savings account and retirement account for employee, 
		 * each with a starting balance of $300.
		 * */
		Account account01 = new Account(employee, AccountType.CHECKING, 300);
		Account account02 = new Account(employee, AccountType.SAVINGS, 300);
		Account account03 = new Account(employee, AccountType.RETIREMENT, 300);
		System.out.println(employee.toString());
		System.out.println(account01.toString());
		System.out.println(account02.toString());
		System.out.println(account03.toString());
	}

}
