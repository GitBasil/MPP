package grading;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import prob1.Customer;
import prob1.Problem1;


public class TestProb1 extends TestCase {
	public void testFirstMethod_Output() {
		List<String> expected = Arrays.asList(new String[] {"friend", "bat", "strong", "weak"});
		List<String> list1 = Arrays.asList(new String[]{"friend", "tree", "bike", "bat"});
		List<String> list2 = Arrays.asList(new String[]{"tree", "strong", "bike", "weak"});
		List<String> output = Problem1.elementsInJustOne(list1, list2);
		assertTrue("Problem 1, first problem: Expected 'friend', 'bat', 'strong', 'weak', but got " + output, Auxil.sameElements(expected, output));
	}
	public void testSecondMethod_CorrectElements() {
		List<String> expected = Arrays.asList(new String[]{"Anna", "Bob"});
		Customer cust1 = new Customer("Bob", "11 Adams", "Fairfield", "52556");
		Customer cust2 = new Customer("Laurence Lebihans",	"12, rue des Bouchers",	"Marseille","13008");
		Customer cust3 = new Customer("Andy", "1000 Channing Ave", "Palo Alto", "94301");
		Customer cust4 = new Customer("Zeke", "212 Wilkshire Blvd", "Chicago", "57532");
		Customer cust5 = new Customer("Blauer Delikatessen", "Forsterstr. 57","Mannheim", "68306");
		Customer cust6 = new Customer("Anna", "1000 N 4th", "Fairfield", "52557");
		List<Customer> list = Arrays.asList(cust1, cust2, cust3, cust4, cust5, cust6);
		List<String> studentResult = Problem1.getAllFairfieldCustomers(list);
		assertTrue("Problem 1, first problem: Expected 'Anna', 'Bob' but got " + studentResult, 
				Auxil.sameElements(expected, studentResult));
	}
	public void testSecondMethod_CorrectOrderingOfElements() {
		List<String> expected = Arrays.asList(new String[]{"Anna", "Bob"});
		Customer cust1 = new Customer("Bob", "11 Adams", "Fairfield", "52556");
		Customer cust2 = new Customer("Laurence Lebihans",	"12, rue des Bouchers",	"Marseille","13008");
		Customer cust3 = new Customer("Andy", "1000 Channing Ave", "Palo Alto", "94301");
		Customer cust4 = new Customer("Zeke", "212 Wilkshire Blvd", "Chicago", "57532");
		Customer cust5 = new Customer("Blauer Delikatessen", "Forsterstr. 57","Mannheim", "68306");
		Customer cust6 = new Customer("Anna", "1000 N 4th", "Fairfield", "52557");
		List<Customer> list = Arrays.asList(cust1, cust2, cust3, cust4, cust5, cust6);
		List<String> studentResult = Problem1.getAllFairfieldCustomers(list);
		if(!Auxil.sameElements(expected, studentResult)) {
			System.out.println("Did not test for correct sorted order since elements of output list are not correct");
		} else {
			assertEquals("Elements of output list are correct but not in correct sorted order", expected, studentResult);
		}
	}
	public void test_UsedForLoop() {
		String pathToProblem1 = "\\src\\prob1\\Problem1.java";
		assertFalse("Student's code uses a for loop", Auxil.usesForLoop(pathToProblem1));
	}
	
	public void test_UsedWhileLoop() {
		String pathToProblem1 = "\\src\\prob1\\Problem1.java";
		assertFalse("Student's code uses a while loop", Auxil.usesWhileLoop(pathToProblem1));
	}
}