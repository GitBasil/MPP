package Practice_mdExam.One;

public class SavingAccount extends Account {
    private double balance;
    private double monthelyFee;
    private String accId;

    @Override
    public String getAccountID() {
        return accId;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double computeUpdatedBalance() {
    }
    
}
