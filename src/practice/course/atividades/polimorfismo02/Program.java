package practice.course.atividades.polimorfismo02;

import practice.course.atividades.polimorfismo02.entities.ImportedProduct;
import practice.course.atividades.polimorfismo02.entities.Product;
import practice.course.atividades.polimorfismo02.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.print("\nProduct #" + i + " data:"
                    + "\nCommon, used or imported (c/u/i)? ");
            char productType = sc.next().toLowerCase().charAt(0);

            while (productType != 'c' && productType != 'u' && productType != 'i') {
                System.out.print("\n[ERROR] Invalid option!" + "\nEnter the product type: ");
                productType = sc.next().toLowerCase().charAt(0);
            }

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: $ ");
            Double price = sc.nextDouble();

            switch (productType) {
                case 'i':
                    System.out.print("Customs fee: $ ");
                    Double fee = sc.nextDouble();
                    products.add(new ImportedProduct(name, price, fee));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    String stringData = sc.next().trim();

                    LocalDate data = null;
                    while (data == null) {
                        try {
                            data = LocalDate.parse(stringData, fmt);
                        } catch (DateTimeParseException e) {
                            System.out.print("Invalid date! Please, type in correct format (DD/MM/YYYY): ");
                            stringData = sc.next();
                        }
                    }
                    products.add(new UsedProduct(name, price, data));
                    break;
                case 'c':
                    products.add(new Product(name, price));
                    break;
            }
        }

        System.out.println("\nPRICE TAGS:");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }
        System.out.println("\nList size: " + products.size() + " items.");
        sc.close();
    }
}
