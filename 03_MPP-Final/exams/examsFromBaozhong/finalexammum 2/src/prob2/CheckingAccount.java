package prob2;

/**
 * Implement code by class diagram and problem description
 */
public class CheckingAccount extends Account {
	private double rate;
	
	public CheckingAccount(String accountID, double balance, double rate) {
		super(accountID, balance);
		this.rate = rate;
	}

	@Override
	public String getAccountID() {
		return accountID;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public double computeBalance() {
		return balance - balance * rate;
	}

}
