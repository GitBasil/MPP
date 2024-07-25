package Practice_mdExam.One;

public class CheckingAccount extends Account {
    private double balance;
    private double monthelyFee;
    private String accId;

    CheckingAccount(String accId){
        this.accId = accId;
    }

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
