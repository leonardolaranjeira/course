package practice.course.atividades.interface02.model.services;

import practice.course.atividades.interface02.model.entities.Contract;
import practice.course.atividades.interface02.model.entities.Instalment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService paymentService;


    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }


    public void processContract(Contract contract, Integer months) {
        double baseValue = contract.getTotalValue() / months;


        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double netValue = paymentService.interest(baseValue, i);
            netValue = paymentService.paymentFee(netValue);

            contract.addInstalment(new Instalment(dueDate, netValue));
        }
    }
}
