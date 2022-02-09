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

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Client getClient() {
        return client;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Double totalPrice() {
        Double sum = 0.0;
        for (OrderItem item : items)
            sum += item.subTotal();
        return sum;
    }
}