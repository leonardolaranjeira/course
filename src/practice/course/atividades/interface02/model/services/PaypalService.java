package practice.course.atividades.interface02.model.services;

public class PaypalService implements OnlinePaymentService {
    public static final double INTEREST = 0.01;
    public static final double PAYMENT_FEE = 0.02;

    @Override
    public Double paymentFee(Double amount) {
        return amount + (amount * PAYMENT_FEE);
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount + ((amount * INTEREST) * months);
    }
}
