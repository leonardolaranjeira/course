package practice.pedidoatv01.entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Double subTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return product.getName()
                + ", Quantity: " + quantity
                + ", Unit price: $" + String.format("%.2f", price)
                + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}
