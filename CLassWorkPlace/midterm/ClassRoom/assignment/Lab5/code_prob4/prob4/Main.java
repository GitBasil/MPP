package ClassRoom.assignment.Lab5.code_prob4.prob4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = CustOrderFactory.createCustomer("John Doe");
        Order order1 = CustOrderFactory.createOrder(customer, LocalDate.of(2023, 6, 1));
        Order order2 = CustOrderFactory.createOrder(customer, LocalDate.of(2023, 6, 2));

    }
}
