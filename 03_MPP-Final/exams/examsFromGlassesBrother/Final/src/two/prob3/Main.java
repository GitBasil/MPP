package two.prob3;

public class Main {

	public static void main(String[] args) {
		
			Employee[] emps = new Employee[10];
			emps[0]= new Employee("Jim Jones", new int[]{5000,5000,6000});
			emps[1]= new Employee("Jim Jackson",  new int[]{5000,6000,6000});
			emps[2]= new Employee("John Jones",  new int[]{7000,7000,7000});
			emps[3]= new Employee("John Jackson",  new int[]{5000,6000,7000});
			emps[4]= new Employee("Anne Jones",  new int[]{5000,5000,6000});
			emps[5]= new Employee("Tom Jones",  new int[]{5000,5000,5000});
			emps[6]= new Employee("Anne Davis",  new int[]{5000,5000,5000});
			emps[7]= new Employee("Jim Davis",  new int[]{5000,6000,6000});
			emps[8]= new Employee("Davis Jones",  new int[]{6000,6000,6000});
			emps[9]= new Employee("Anne Thomas",  new int[]{5000,5000,6000});
			
			QuarterlyReport qr = new QuarterlyReport();
			for(int i = 0; i < 10; ++i) {
				qr.addEntry(new QuarterlySalary(emps[i].getThreeMonthSalary()), emps[i]);
			}
			
			
			QuarterlySalary qs = new QuarterlySalary(new int[]{5000,5000,6000});
			
			System.out.println(qr.lookup(qs));

	}

}
