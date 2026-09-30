package lw02.unguided;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("orders.txt"));
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> food = new LinkedList<>();
        food.add(new String[]{"Bakso", "2"});
        food.add(new String[]{"Sate", "1"});
        food.add(new String[]{"Soto", "2"});
        LinkedList<String[]> drink = new LinkedList<>();
        drink.add(new String[]{"EsTeh", "4"});  
        drink.add(new String[]{"EsJeruk", "2"});
        LinkedList<String[]> successful = new LinkedList<>();
        Queue<String[]> q = new LinkedList<>();
        Stack<String[]> fails = new Stack<>();

        while (scanner.hasNext()) {
            String[] order = new String[4];
            order[0] = scanner.next(); //nama
            order[1] = scanner.next(); //food
            order[2] = scanner.next(); //drink
            order[3] = scanner.next(); //table
            orders.add(order);
        }
        scanner.close();

        q.addAll(orders);

        while (!q.isEmpty()) {
            String[] order = q.poll();
            String name = order[0];
            String foodName = order[1];
            String drinkName = order[2];
            String table = order[3];

            String[] foods = null;
            String[] drinks = null;

            if (!foodName.equals("-")) {
                for (String[] data : food) {
                    if (data[0].equals(foodName)) {
                        foods = data;
                        break;
                    }
                }
            }

            if (!drinkName.equals("-")) {
                for (String[] data : drink) {
                    if (data[0].equals(drinkName)) {
                        drinks = data;
                        break;
                    }
                }
            }

            boolean foodAvailable = true;
            boolean drinkAvailable = true;

            if (foods != null) {
                int stock = Integer.parseInt(foods[1]);

                if (stock <= 0) {
                    foodAvailable = false;
                }
            }

            if (drinks != null) {
                int stock = Integer.parseInt(drinks[1]);

                if (stock <= 0) {
                    drinkAvailable = false;
                }
            }

            if (foodAvailable && drinkAvailable) {
                successful.add(order);

                if (foods != null) {
                    int stock = Integer.parseInt(foods[1]);
                    stock--;
                    foods[1] = String.valueOf(stock);
                }

                if (drinks != null) {
                    int stock = Integer.parseInt(drinks[1]);
                    stock--;
                    drinks[1] = String.valueOf(stock);
                }

            } else {
                fails.push(order);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for (String[] a : successful) {
            System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
        }

        System.out.println("=== Remaining Food Stock ===");
        for (String[] a : food) {
            System.out.println(a[0] + " : " + a[1]);
        }

        System.out.println("=== Remaining Drink Stock ===");
        for (String[] a : drink) {
            System.out.println(a[0] + " : " + a[1]);
        }

        System.out.println("=== Failed Orders ===");
        while (!fails.isEmpty()) {
            String[] fail = fails.pop();
            System.out.println(fail[0] + " " + fail[1] + " " + fail[2] + " " + fail[3]);
        }
    } 
}
