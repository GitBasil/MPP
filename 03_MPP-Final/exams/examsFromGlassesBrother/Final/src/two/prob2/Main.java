package two.prob2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// load up some test data
		Customer cust1 = new Customer("Bob", "11 Adams", "Fairfield", "52556");
		Customer cust2 = new Customer("Laurence Lebihans", "12, rue des Bouchers", "Marseille", "13008");
		Customer cust3 = new Customer("Andy", "1000 Channing Ave", "Palo Alto", "94301");
		Customer cust4 = new Customer("Zeke", "212 Wilkshire Blvd", "Chicago", "57532");
		Customer cust5 = new Customer("Blauer Delikatessen", "Forsterstr. 57", "Mannheim", "68306");
		Customer cust6 = new Customer("Anna", "1000 N 4th", "Fairfield", "52557");
		List<Customer> list = Arrays.asList(cust1, cust2, cust3, cust4, cust5, cust6);

		// Task:get all names of customers who live in Fairfield, in sorted order

		List<String> returnList = list.stream().filter(x -> x.getCity().equals("Fairfield")).map(x -> x.getName())
				.sorted().collect(Collectors.toList());
		System.out.println(returnList);
	}

}
