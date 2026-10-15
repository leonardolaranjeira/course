package practice.course.atividades.interface01.model.services;

import practice.course.atividades.interface01.model.entities.CarRental;
import practice.course.atividades.interface01.model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    public static final double HOUR = 60.0;
    public static final double NOON = 12.0;
    public static final double DAY = 24.0;


    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;


    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }


    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / HOUR;

        double basicPayment;
        if (hours <= NOON) {
            basicPayment = pricePerHour * Math.ceil(hours);
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / DAY);
        }

        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
