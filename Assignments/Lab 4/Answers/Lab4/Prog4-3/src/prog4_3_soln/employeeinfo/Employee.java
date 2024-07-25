package prog4_3_soln.employeeinfo;

import java.time.LocalDate;
import prog4_3_soln.MyStringList;

public class Employee {
	private AccountList accounts;
	private String name;
	@SuppressWarnings("unused")
	private LocalDate hireDate;
	@SuppressWarnings("unused")
	private String n = System.getProperty("line.separator");
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
		accounts =  new AccountList();
	}
	public void createNewChecking(double startAmount) {
		accounts.add(new CheckingAccount(this,startAmount));
	}
	public void createNewSavings(double startAmount) {
		Account acct = new SavingsAccount(this,startAmount);
		accounts.add(acct);
	}
	public void createNewRetirement(double startAmount) {
		Account acct = new RetirementAccount(this,startAmount);
		accounts.add(acct);
	}
	public String getFormattedAcctInfo() {
		String newline = System.getProperty("line.separator");
		String theString = "ACCOUNT INFO FOR "+this.name+newline+newline;
		for(int i=0;i < accounts.size();i++) {
			theString += accounts.get(i)+newline;
		}
		return theString;
	}
	public void deposit(int accountIndex, double amt) {
		Account selected = accounts.get(accountIndex);
		selected.makeDeposit(amt);
	}
	public boolean withdraw(int accountIndex, double amt){
		Account selected = accounts.get(accountIndex);
		return selected.makeWithdrawal(amt);
	}
	
	/** returns a list of account types in the order in which 
	 *  accounts are stored in the AccountList
	 **/
	public MyStringList getNamesOfAccounts(){
		MyStringList names = new MyStringList();
		for(int i = 0; i < accounts.size(); ++i){
			names.add(accounts.get(i).getAcctType().toString().toLowerCase());
		}
		return names;
	}
	public String getName() {
		return name;
	}
}