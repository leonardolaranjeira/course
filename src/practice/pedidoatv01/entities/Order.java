package practice.pedidoatv01.entities;

import practice.pedidoatv01.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime moment = LocalDateTime.now();
    private OrderStatus status;
    private Client client;
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private List<OrderItem> orderList = new ArrayList<>();

    public Order(OrderStatus status, Client client) {
        this.moment = LocalDateTime.now();
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem item) {
        orderList.add(item);
    }

    public void removeItem(OrderItem item) {
        orderList.remove(item);
    }

    public Double total() {
        double sum = 0.0;
        for (OrderItem item : orderList) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nORDER SUMMARY:\n");
        sb.append("Order moment: ").append(moment.format(fmt)).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("Client: ").append(client).append("\n");
        sb.append("\nORDER ITEMS:\n");
        for (OrderItem item : orderList) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total price: $").append(String.format("%.2f", total()));
        return sb.toString();
    }
}
