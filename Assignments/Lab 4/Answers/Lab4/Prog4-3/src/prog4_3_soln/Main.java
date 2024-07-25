package prog4_3_soln;

import java.util.Scanner;

import prog4_3_soln.employeeinfo.Employee;

public class Main {
	Employee[] emps = null;
	public static void main(String[] args) {
		new Main();
	}
	Main() {
		emps = new Employee[3];
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2,13);
		
		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);	
		
		String newline = System.getProperty("line.separator");
		Scanner sc = new Scanner(System.in);
		System.out.print("A. See a report of all accounts."+newline
				       + "B. Make a deposit."+newline
				       + "C. Make a withdrawal."+newline
				       + "Make a selection (A/B/C): ");
		String answer = sc.next();
		
		if(answer.equalsIgnoreCase("A")) {
			String info = getFormattedAccountInfo();
			System.out.println(newline+info+newline);
		}
		else if(answer.equalsIgnoreCase("B")) {
			String infoEmployees = getNameOFEmployees();
			System.out.print(newline+infoEmployees+"Select an employee: (type a number) ");
			answer = sc.next();
			int selectedEmpNumber = Integer.parseInt(answer);
			if(selectedEmpNumber < emps.length) {
				int accLength = emps[selectedEmpNumber].getNamesOfAccounts().size();
				for(int a=0;a < accLength;a++) {
					System.out.print(a+". "+emps[selectedEmpNumber].getNamesOfAccounts().get(a)+newline);
				}
				System.out.print("Select an account: (type a number) ");
				answer = sc.next();
				int selectedAccountType = Integer.parseInt(answer);
				if(selectedAccountType < accLength) {
					System.out.print("Deposit amount: ");
					answer = sc.next();
					double depositAmount = Double.parseDouble(answer);
					if(depositAmount > 0) {
						emps[selectedEmpNumber].deposit(selectedAccountType, depositAmount);
						String accName = emps[selectedEmpNumber].getNamesOfAccounts().get(selectedAccountType);
						System.out.print("$"+depositAmount+" has been deposited in the "+newline+
								         accName+" account of "+emps[selectedEmpNumber].getName());
					} else {
						System.out.println("Wrong, Please try again!");
					} 
				} else {
					System.out.println("Wrong, Please try again!");
				}
			} else {
				System.out.println("Wrong, Please try again!");
			}
		}
		else if(answer.equalsIgnoreCase("C")) {
			String infoEmployees = getNameOFEmployees();
			System.out.print(newline+infoEmployees+"Select an employee: (type a number) ");
			answer = sc.next();
			int selectedEmpNumber = Integer.parseInt(answer);
			if(selectedEmpNumber < emps.length) {
				int accLength = emps[selectedEmpNumber].getNamesOfAccounts().size();
				for(int a=0;a < accLength;a++) {
					System.out.print(a+". "+emps[selectedEmpNumber].getNamesOfAccounts().get(a)+newline);
				}
				System.out.print("Select an account: (type a number) ");
				answer = sc.next();
				int selectedAccountType = Integer.parseInt(answer);
				if(selectedAccountType < accLength) {
					System.out.print("Withdrawal amount: ");
					answer = sc.next();
					double withdrawal = Double.parseDouble(answer);
					if(withdrawal > 0) {
						if(emps[selectedEmpNumber].withdraw(selectedAccountType, withdrawal)) {
							String accName = emps[selectedEmpNumber].getNamesOfAccounts().get(selectedAccountType);
							System.out.print("$"+withdrawal+" has been withdrawal in the "+newline+
								         accName+" account of "+emps[selectedEmpNumber].getName());
						} else {
							System.out.println("Sorry, your amount is not enough!");
						}
					} else {
						System.out.println("Wrong, Please try again!");
					} 
				} else {
					System.out.println("Wrong, Please try again!");
				}
			} else {
				System.out.println("Wrong, Please try again!");
			}
		}
		sc.close();
	}
	String getFormattedAccountInfo() {
		String newline = System.getProperty("line.separator");
		String retVal = "";
		for(int i = 0; i < emps.length; ++i){
			retVal += (emps[i].getFormattedAcctInfo() + newline);
		}
		return retVal;
	}
	
	String getNameOFEmployees() {
		String newline = System.getProperty("line.separator");
		String retName = "";
		for(int i = 0; i < emps.length; ++i){
			retName += (i+". "+emps[i].getName()+ newline);
		}
		return retName;
	}
}