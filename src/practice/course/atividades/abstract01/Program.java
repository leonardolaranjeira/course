package practice.course.atividades.abstract01;

import practice.course.atividades.abstract01.entities.Circle;
import practice.course.atividades.abstract01.entities.Rectangle;
import practice.course.atividades.abstract01.entities.Shape;
import practice.course.atividades.abstract01.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int num = sc.nextInt();

        List<Shape> shapes = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            System.out.print("\nShape #" + i + " data:"
                    + "\nRectangle or Circle (r/c)? ");
            char choice = sc.next().toLowerCase().charAt(0);

            while (choice != 'r' && choice != 'c') {
                System.out.print("\nInvalid choice, please try again.");
                choice = sc.next().toLowerCase().charAt(0);
            }

            System.out.print("Choose the color:"
                    + "\n1 - BLACK"
                    + "\n2 - BLUE"
                    + "\n3 - RED"
                    + "\nColor: ");
            int option = sc.nextInt();

            while (option < 1 || option > 3) {
                System.out.print("\nInvalid option, please try again."
                        + "\n1 - BLACK"
                        + "\n2 - BLUE"
                        + "\n3 - RED"
                        + "\nColor: ");
                option = sc.nextInt();
            }

            Color color = switch (option) {
                case 1 -> Color.BLACK;
                case 2 -> Color.BLUE;
                case 3 -> Color.RED;
                default -> null;
            };

            if (choice == 'r') {
                System.out.print("Width: ");
                Double width = sc.nextDouble();

                System.out.print("Height: ");
                Double height = sc.nextDouble();

                shapes.add(new Rectangle(color, width, height));
            } else {
                System.out.print("Radius: ");
                Double radius = sc.nextDouble();

                shapes.add(new Circle(color, radius));
            }
        }
        System.out.println("\nSHAPE AREAS:");
        for (Shape shape : shapes) {
            System.out.printf("%.2f%n", shape.area());
        }
        sc.close();
    }
}