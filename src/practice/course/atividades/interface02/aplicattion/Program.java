package practice.course.atividades.interface02.aplicattion;

import practice.course.atividades.interface02.model.entities.Contract;
import practice.course.atividades.interface02.model.entities.Instalment;
import practice.course.atividades.interface02.model.services.ContractService;
import practice.course.atividades.interface02.model.services.OnlinePaymentService;
import practice.course.atividades.interface02.model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("\nEntre com os dados do contrato:\nNúmero: ");
            int number = sc.nextInt();

            sc.nextLine();
            System.out.print("Data (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), dtf);

            System.out.print("Valor do contrato: R$ ");
            double value = sc.nextDouble();

            Contract contract = new Contract(number, date, value);

            System.out.print("Entre com o número de parcelas: ");
            int qttInstalments = sc.nextInt();

            OnlinePaymentService paymentService = new PaypalService();
            ContractService service = new ContractService(paymentService);

            service.processContract(contract, qttInstalments);

            System.out.println("\nParcelas:");
            for (Instalment instalment : contract.getInstalments()) {
                System.out.println(
                        instalment.getDueDate().format(dtf)
                                + " - R$ "
                                + String.format("%.2f", instalment.getAmount())
                );
            }

        } catch (RuntimeException e) {
            System.out.println("[ERRO] Dado inválido.");
        }

        sc.close();
    }
}
