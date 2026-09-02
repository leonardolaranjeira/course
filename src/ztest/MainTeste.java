package ztest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainTeste {
    static void main() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dateFormat = now.format(fmt);

        System.out.println(dateFormat);
    }
}
