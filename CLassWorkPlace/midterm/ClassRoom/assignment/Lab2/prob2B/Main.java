package prob2B;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(){
        Order order = new Order(12345);

        OrderLine orderLine1 = new OrderLine(order, 10);
        OrderLine orderLine2 = new OrderLine(order, 15);

        System.out.println(order.getOrderNum());
        for (OrderLine orderLine : order.getOrderLines()) {
            System.out.println(orderLine.getOrderQuantity());
        }
    }
}

class Order {
    private int orderNum;
    private List<OrderLine> orderLines;

    public Order(int orderNum){
        this.orderLines = new ArrayList<>();
        this.orderNum = orderNum;
    }
    
    public int getOrderNum() {
        return orderNum;
    }

    public void addOrderLine(OrderLine orderLine){
        this.orderLines.add(orderLine);
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
}

class OrderLine {
    private int orderQuantity;
    private Order order;
    public OrderLine(Order order, int orderQuantity) {
        this.order = order;
        order.addOrderLine(this);
        this.orderQuantity = orderQuantity;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public Order getOrder() {
        return order;
    }
}