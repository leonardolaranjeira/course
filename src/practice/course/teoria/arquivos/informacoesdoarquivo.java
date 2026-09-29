package practice.course.teoria.arquivos;

import java.io.File;
import java.util.Scanner;

public class informacoesdoarquivo {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);
        System.out.print("\ngetPath: " + path.getPath());
        System.out.print("\ngetParent: " + path.getParent());
        System.out.print("\ngetName: " + path.getName());

        sc.close();
    }
}
