package prog4_1_soln;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * Initial Values
		 * */
		int numPublications = 10;
		double overtimeHours = 200;
		/*
		 * Create Array Of Departments 
		 */
		DeptEmployee[] department = new DeptEmployee[5];
		department[0] = new Professor("Mo", 1000, 2010,11,11,numPublications);
		department[1] = new Professor("Hassan", 1000, 2012,9,20,numPublications);
		department[2] = new Professor("AlDini", 1000, 2013,12,10,numPublications);
		department[3] = new Secretary("Secre01", 250, 2015, 8, 2,overtimeHours);
		department[4] = new Secretary("Secre02", 250, 2016, 10, 1,overtimeHours);
	
		Scanner input = new Scanner(System.in);
		System.out.print("Are your wishes to see the sum of all salaries in the department? Enter Y if yes!   ");
        String userinput = input.nextLine();
        if(userinput.equals("Y")) {
        	double total = 0;
        	for(DeptEmployee d: department) {
        		total += d.computeSalary();
        	}
			System.out.println("Total: "+total);
		}
        input.close();
	}
}


/*
Then ask the user if he wishes to see the sum of all salaries in the department. 
If the user responds "Y", then loop through the department array and polymorphically read, and sum, 
all salaries, and output the result to the console.
*/