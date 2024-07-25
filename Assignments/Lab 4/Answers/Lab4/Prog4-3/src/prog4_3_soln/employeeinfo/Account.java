package prog4_3_soln.employeeinfo;

abstract public class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	//private AccountType acctType;
	@SuppressWarnings("unused")
	private Employee employee;
	
	Account(Employee emp, double startBalance){
		employee = emp;
		//this.acctType =acctType;
		this.balance = startBalance;
	}
	Account(Employee emp){
		this(emp,DEFAULT_BALANCE);	
	}
	abstract public AccountType getAcctType();
	public String toString() {
		String newline = System.getProperty("line.separator");
		return "Account type: "+newline +
				"Current bal: "+balance;//+ acctType.toString().toLowerCase()
	}
	public void makeDeposit(double amount) {
		balance += amount;
	}
	public boolean makeWithdrawal(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
	/*****/
	double getBalance(){
		return balance;
	}
	/** used by subclasses only */
	void setBalance(double bal){
		balance = bal;
	}
	void updateBalance() {
		//by default do nothing
	}
	public Employee getEmp(){
		return employee;
	}
}
