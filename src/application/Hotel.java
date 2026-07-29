package application;

import java.util.Locale;
import java.util.Scanner;

public class Hotel {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("\nHow many rooms will be rented? ");
        int qtt = sc.nextInt();
        sc.nextLine();

        int room;
        String[][] rooms = new String[10][3];

        for (int i = 0; i < qtt; i++) {
            System.out.println("\nRent #" + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine().toLowerCase();

            while (true) {
                System.out.print("Room: ");
                room = sc.nextInt();
                sc.nextLine();

                if (room < 0 || room > 9) {
                    System.out.println("[ERRO] Número de quarto inválido.");
                } else if (rooms[room][0] != null) {
                    System.out.println("[ERRO] Quarto " + room + " já está ocupado. Escolha outro.");
                } else {
                    break;
                }
            }

            String[] rent = { name, email, String.valueOf(room) };
            rooms[room] = rent;
        }

        System.out.println("\nBusy rooms: ");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i][0] != null) {
                System.out.println(i + ": "
                        + rooms[i][0] + ", "
                        + rooms[i][1]);
            }
        }

        sc.close();
    }
}
