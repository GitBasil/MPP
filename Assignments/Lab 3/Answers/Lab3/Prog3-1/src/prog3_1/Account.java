package prog3_1;

class Account {
	//public final static String CHECKING = "checking";
	//public final static String SAVINGS = "savings";
	//public final static String RETIREMENT = "retirement";
	private AccountType acctType;
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	//private String acctType;
	private Employee employee;

	Account(Employee emp, AccountType accountType, double balance) {
		this.employee = emp;
		setAccountType(accountType);
		this.balance = balance;
	}

	Account(Employee emp, AccountType accountType) {
		this(emp, accountType, DEFAULT_BALANCE);
	}

	public AccountType getAccountType() {
		return this.acctType;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	private void setAccountType(AccountType accountType) {
    	this.acctType = accountType;

    }

	public String toString() {
		return "type = " + getAccountType() + ", balance = " + balance;
	}
	
	public void makeDeposit(double deposit) {
		this.balance = this.balance + deposit;
	}

	public boolean makeWithdrawal(double amount) {
		if(amount > this.balance) {
			return false;
		} 
		else  
		{
			this.balance = this.balance - amount;
			return true;
		}
		
	}
}
