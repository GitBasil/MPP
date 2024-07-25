package employeeinfo;

import java.time.LocalDate;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	@SuppressWarnings("unused")
	private LocalDate hireDate;
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	
	public void createNewChecking(double startAmount) {
		checkingAcct = new Account(this, AccountType.CHECKING, startAmount);
	}

	public void createNewSavings(double startAmount) {
		savingsAcct = new Account(this, AccountType.SAVINGS, startAmount);
	}

	public void createNewRetirement(double startAmount) {
		retirementAcct = new Account(this, AccountType.RETIREMENT, startAmount);
		
	}

	public String getFormattedAcctInfo() {
		String newline = System.getProperty("line.separator");
		String theString = "ACCOUNT INFO FOR "+name+newline+newline;
		if(checkingAcct != null) theString += checkingAcct.toString()+newline;
		if(savingsAcct != null) theString += savingsAcct.toString()+ newline;
		if(retirementAcct != null) theString += retirementAcct.toString()+ newline;
		return theString;
	}
	public void deposit(AccountType acctType, double amt){
		switch(acctType){
			case CHECKING:
				checkingAcct.makeDeposit(amt);
				break;
			case SAVINGS:
				savingsAcct.makeDeposit(amt);
				break;
			case RETIREMENT:
				retirementAcct.makeDeposit(amt);
				break;
			default:				
		}
	}
	public boolean withdraw(AccountType acctType, double amt){
		switch(acctType){
		case CHECKING:
			return checkingAcct.makeWithdrawal(amt);
			
		case SAVINGS:
			return savingsAcct.makeWithdrawal(amt);
			
		case RETIREMENT:
			return retirementAcct.makeWithdrawal(amt);
			
		default:
			return false;
		
			
		}
	}

}
