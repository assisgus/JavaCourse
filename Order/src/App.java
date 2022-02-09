import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;



public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        System.out.println("Enter the client data: ");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Order Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(status, client);
        
        System.out.print("How many items? ");
        Integer items = sc.nextInt();
        for (int i = 1 ; i <= items ; i++) {
            System.out.println("Enter the item #" + i + " data: ");
            System.out.print("Product name: ");
            String productName =  sc.next();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();
            Product product =  new Product(productName, productPrice);
            OrderItem item = new OrderItem(productQuantity, product);
            order.addItem(item);
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + sdf2.format(order.getMoment()));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client.getName() + " " + client.getEmail() + " " + sdf.format(client.getBirthDate()));
        System.out.println("Order Items: ");
        for (OrderItem item : order.getItems())
            System.out.println(item.getProduct().getName() + ", Quantity: " + item.getQuantity() + ", Subtotal: " + item.subTotal());
        System.out.println("Total price: " + order.totalPrice());
        sc.close();    
    }
}
