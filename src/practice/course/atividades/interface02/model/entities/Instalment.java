package practice.course.atividades.interface02.model.entities;

import java.time.LocalDate;

public class Instalment {
    private LocalDate dueDate;
    private Double amount;


    public Instalment() {
    }

    public Instalment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }


    public LocalDate getDueDate() { return dueDate; }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
