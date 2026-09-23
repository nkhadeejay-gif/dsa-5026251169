package lw01.unguided;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<WashService> washes = new ArrayList<>();

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("washes.txt"));

        int total = scanner.nextInt();
        
         for (int i = 0; i < total; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            if (type.equals("CAR")) {
                washes.add(new CarWash(id, days, units));
            } else if (type.equals("MOTORCYCLE")) {
                washes.add(new MotorcycleWash(id, days, units));
            }
        }

        scanner.close();

        for (WashService wash : washes) {
            System.out.println(wash.summary());
        }
    }
}
