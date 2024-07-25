package prob2;

/**
 * Implement code by class diagram and problem description
 */
public class SavingAccount extends Account {
	private double monthlyFee;
	
	public SavingAccount(String accountID, double balance, double monthlyFee) {
		super(accountID, balance);
		this.monthlyFee = monthlyFee;
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
		return balance + monthlyFee;
	}

}
