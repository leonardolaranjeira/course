package practice.course.atividades.interface02.model.services;

public interface OnlinePaymentService {
    Double paymentFee(Double amount);

    Double interest(Double amount, Integer months);
}
