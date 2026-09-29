package practice.course.atividades.filereading01.Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);

        String strPath = "B:\\arquivos\\study\\development\\java\\src\\practice\\course\\atividades\\leituradearquivo\\out\\summary.csv";
        File path = new File(strPath);

        try ( BufferedReader br = new BufferedReader( new FileReader(path) )) {
            String name;
            int qtt;
            double total, value;
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                name = line.split(",")[0];
                value = Double.parseDouble(line.split(",")[1]);
                qtt = Integer.parseInt(line.split(",")[2]);
                total = (value * qtt);

                System.out.printf("%s, %.2f%n", name, total);
            }

        } catch (Exception e) {
            System.out.print("[ERRO] Arquivo não encontrado.");

        }
    }
}
