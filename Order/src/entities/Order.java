package entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import enums.OrderStatus;

public class Order {
    private Date moment;
    private OrderStatus status;
    
    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order() {
    }

    public Order(OrderStatus status, Client client) {
        moment = new Date();
        this.client = client;
        this.status = status;
    }
}