package practice.course.basics.application;

import java.util.Locale;
import java.util.Scanner;

public class Rectangle {
    static void main() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        practice.course.basics.entities.Rectangle rectangle = new practice.course.basics.entities.Rectangle();
        System.out.println("Enter rectangle width and height!");
        System.out.print("Width: ");
        rectangle.width = sc.nextDouble();

        System.out.print("Height: ");
        rectangle.height = sc.nextDouble();

        System.out.println("\nArea: " + rectangle.area()
                        + "\nPerimeter: " + rectangle.perimeter()
                        + "\nDiagonal: " + rectangle.diagonal());

        sc.close();
    }
}
