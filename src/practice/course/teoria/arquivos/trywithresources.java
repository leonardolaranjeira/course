package practice.course.teoria.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class trywithresources {
    static void main() {

        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                System.out.print(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
