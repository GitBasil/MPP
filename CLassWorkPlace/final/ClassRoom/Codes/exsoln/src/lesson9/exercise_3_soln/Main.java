package lesson9.exercise_3_soln;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

	//Use Comparator.comparing and thenComparing to sort 
	//the list by balance and then by ownerName
	//Collect your stream into a list and print the sorted 
	//result to the console
	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<Account>() {
			{
				add(new Account("Bob", 5000, 1001));
				add(new Account("Jim", 10000, 1002));
				add(new Account("Bruce", 5300, 1003));
				add(new Account("Rick", 12000, 1004));
				add(new Account("Sam", 9000, 1005));
				add(new Account("Li", 12000, 1006));
			}
		};
		
		List<Account> sorted 
		  = accounts.stream()
				    .sorted(Comparator.comparing((Account a) -> a.getBalance())
				            .thenComparing(a -> a.getOwnerName()))
				    .collect(Collectors.toList());
		System.out.println(sorted);
	}

}
