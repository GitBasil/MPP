package ClassRoom.assignment.Lab5.code_prob4.prob4;

import java.time.LocalDate;

public class CustOrderFactory {
    
    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public static Order createOrder(Customer customer, LocalDate orderDetails) {
        Order order = Order.newOrder(customer,orderDetails);
        customer.addOrder(order);
        return order;
    }
}
