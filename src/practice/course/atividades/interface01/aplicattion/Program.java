package practice.course.atividades.interface01.aplicattion;

import practice.course.atividades.interface01.model.entities.CarRental;
import practice.course.atividades.interface01.model.entities.Vehicle;
import practice.course.atividades.interface01.model.services.BrazilTaxService;
import practice.course.atividades.interface01.model.services.RentalService;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {
            System.out.print("\nENTER RENTAL DATA"
                    + "\nCar model: ");
            String model = sc.nextLine();

            System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

            System.out.print("Return (dd/MM/yyyy hh:mm): ");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

            CarRental cr = new CarRental(start, finish, new Vehicle(model));

            System.out.print("Enter price per hour: ");
            double pricePerHour = sc.nextDouble();

            System.out.print("Price per day: ");
            double pricePerDay = sc.nextDouble();

            RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
            rs.processInvoice(cr);

            System.out.println("\nINVOICE:");
            System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
            System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
            System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

        } catch (RuntimeException e) {
            System.out.println("\n[ERRO] Dado inserido inválido!");

        }
        sc.close();
    }
}
