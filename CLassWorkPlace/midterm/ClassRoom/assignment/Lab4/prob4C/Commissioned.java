package prob4C;

import java.time.LocalDate;
import java.util.*;

public class Commissioned extends Employee {
    private double commission;
    private double baseSalary;
    private List<Order> orders;

    public Commissioned(String empId, double commission, double baseSalary) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = new ArrayList<>();
    }

    public void addNewOrder(int orderNo, LocalDate orderDate, double orderAmount)
    {
        Order order = new Order(orderNo, orderDate, orderAmount);
        orders.add(order);
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double totalComm = 0;
        for (Order order : orders) {
            totalComm += order.getOrderAmount() * commission;
        }

        return totalComm + baseSalary;
    }
    
}
