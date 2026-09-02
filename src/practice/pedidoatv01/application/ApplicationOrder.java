package practice.pedidoatv01.application;

import practice.pedidoatv01.entities.Client;
import practice.pedidoatv01.entities.Order;
import practice.pedidoatv01.entities.OrderItem;
import practice.pedidoatv01.entities.Product;
import practice.pedidoatv01.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class ApplicationOrder {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // -- Data solicitation --
        System.out.print("Enter client data:\n"
                        + "Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        LocalDate birthDate = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (birthDate == null) {
            try {
                System.out.print("Birth date (DD/MM/YYYY or just numbers): ");
                String birthDateStr = sc.nextLine();
                birthDate = LocalDate.parse(birthDateStr, fmt);

            } catch (DateTimeParseException e) {
                System.out.println("\nInvalid date format!\nMake sure to include the slashes (15/08/1995).\n");
            }
        }
        Client client = new Client(name, email, birthDate);

        System.out.print("\nEnter order data:\n"
                        + "DELIVERED\n"
                        + "PENDING_PAYMENT\n"
                        + "SHIPPED\n"
                        + "PROCESSING\n"
                        + "Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(status, client);

        System.out.print("How many items to this order? ");
        int qttItems = sc.nextInt() + 1;

        for (int i = 1; i < qttItems; i++) {
            sc.nextLine();
            System.out.print("\nEnter #" + i + " item data:\n"
                            + "Product name: ");
            String nameProduct = sc.nextLine();

            System.out.print("Product price: $");
            Double priceProduct = sc.nextDouble();

            System.out.print("Quantity: ");
            int qttProducts = sc.nextInt();
            Product product = new Product(nameProduct, priceProduct);
            OrderItem items = new OrderItem(qttProducts, priceProduct, product);
            order.addItem(items);
        }

        System.out.println(order);

        sc.close();
    }
}
