package prob2;

/**
 * Implement code by class diagram. 
 *
 */
public abstract class Account {
	protected String accountID;
	protected double balance;
	
	public Account(String accountID, double balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
	}

	public abstract String getAccountID();
	
	public abstract double getBalance();
	
	public abstract double computeBalance();
}
