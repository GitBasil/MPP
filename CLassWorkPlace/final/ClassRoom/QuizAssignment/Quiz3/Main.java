package QuizAssignment.Quiz3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Customer> cus = new ArrayList<>();
        Customer customer1 = new Customer(1, "Alice Johnson", "New York");
        Customer customer2 = new Customer(2, "Bob Smith", "Los Angeles");
        Customer customer3 = new Customer(3, "Tom John", "Chicago");
        Customer customer4 = new Customer(4, "David Brown", "Houston");
        Customer customer5 = new Customer(5, "Eva Davis", "Phoenix");
        Customer customer6 = new Customer(6, "Carol Williams", "Chicago");

        cus.add(customer1);
        cus.add(customer2);
        cus.add(customer3);
        cus.add(customer4);
        cus.add(customer5);
        cus.add(customer6);

        List<String> names = Utli.CUSTOMERS_FROM_CITY.apply(cus,"Chicago");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
