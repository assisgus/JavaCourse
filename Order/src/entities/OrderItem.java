package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    
    public OrderItem() {
    }

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    public Double subTotal() {
        return price * quantity;
    }
}