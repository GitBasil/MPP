package employeeinfo;

public class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	@SuppressWarnings("unused")
	private Employee employee;
	
	Account(Employee emp, AccountType acctType, double balance){
		employee = emp;
		this.acctType =acctType;
		this.balance = balance;
	}
	Account(Employee emp, AccountType acctType){
		this(emp,acctType,DEFAULT_BALANCE);	
		
		
	}
	public double getBalance() {
		return balance;
	}
	
	public AccountType getAcctType() {
		return acctType;
	}
	public String toString() {
		String newline = System.getProperty("line.separator");
		return "Account type: "+ acctType.toString().toLowerCase()+
				newline +
				"Current bal: "+balance;
	}

	public void makeDeposit(double deposit) {
		balance += deposit;
	}
	public boolean makeWithdrawal(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
}
