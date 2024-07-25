package employeeinfo;

import java.time.LocalDate;
//import java.util.Date;
//import java.util.GregorianCalendar;

public class Employee {
	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}
	
	public LocalDate getHireDate() {
		return this.hireDate;
	}
	public String getName() {
		return this.name;
	}
	
	public void createNewChecking(double startAmount) {
		// implement
		this.checkingAcct = new Account(new Employee(getName(),getHireDate().getYear(),getHireDate().getMonthValue(),getHireDate().getDayOfMonth()), AccountType.CHECKING, startAmount);
	}

	public void createNewSavings(double startAmount) {
		// implement
		this.savingsAcct = new Account(new Employee(getName(),getHireDate().getYear(),getHireDate().getMonthValue(),getHireDate().getDayOfMonth()), AccountType.SAVINGS, startAmount);
	}

	public void createNewRetirement(double startAmount) {
		// implement
		this.retirementAcct = new Account(new Employee(getName(),getHireDate().getYear(),getHireDate().getMonthValue(),getHireDate().getDayOfMonth()), AccountType.RETIREMENT, startAmount);
	}

	public String getFormattedAcctInfo() {
		// implement
		String output = "ACCOUNT INFO FOR "+getName()+":\n\n"; 
		if(this.checkingAcct != null)
			output += this.checkingAcct.toString()+"\n";
		if(this.savingsAcct != null)
			output += this.savingsAcct.toString()+"\n";
		if(this.retirementAcct != null)
			output += this.retirementAcct.toString()+"\n";
		output += "\n";
		return output;
	}
	public void deposit(String acctType, double amt){
		// implement
		if(acctType==AccountType.CHECKING.toString()) {
			this.checkingAcct.makeDeposit(amt);
		}
		else if(acctType==AccountType.SAVINGS.toString()) {
			this.savingsAcct.makeDeposit(amt);
		}
		else if(acctType==AccountType.RETIREMENT.toString()) {
			this.retirementAcct.makeDeposit(amt);
		}
	}
	public boolean withdraw(String acctType, double amt){
		// implement
		if(acctType==AccountType.CHECKING.toString()) {
			return checkingAcct.makeWithdrawal(amt);
		}
		else if(acctType==AccountType.SAVINGS.toString()) {
			return savingsAcct.makeWithdrawal(amt);
		}
		else if(acctType==AccountType.RETIREMENT.toString()) {
			return retirementAcct.makeWithdrawal(amt);
		}
		return false;
	}

}
