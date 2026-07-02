package application;

import java.util.Locale;
import java.util.Scanner;

public class Student {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        entities.Student student;
        student = new entities.Student();

        System.out.println("What's your name? ");
        student.name = sc.nextLine();

        for (int i = 1; i < 4; i++) {
            System.out.print(i + "th note: ");
            student.note = sc.nextDouble();
            student.addNote(student.note);
        }

        System.out.println("FINAL GRADE = " + String.format("%.2f", student.sum));
        if (student.sum >= entities.Student.PASSING_GRADE) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
            double missingPoints = entities.Student.PASSING_GRADE - student.sum;
            System.out.println("MISSING " + String.format("%.2f", missingPoints) + " POINTS");
        }

        sc.close();
    }
}
