package lw03.prelab;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("ADD ")) {
                String song = line.substring(4);
                playlist.add(song);
            } else if (line.startsWith("INSERT ")) {
                String[] parts = line.split(" ", 3);
                int index = Integer.parseInt(parts[1]);
                String song = parts[2];
                playlist.add(index, song);
            } else if (line.startsWith("REMOVE ")) {
                String song = line.substring(7);
                playlist.remove(song);
            }
        }

        scanner.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        Scanner scanner2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int duplicateCount = 0;

        while(scanner2.hasNextLine()) {
            String name = scanner2.nextLine();
            if (!participants.add(name)) {
                duplicateCount++;
            }
        }

        scanner2.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int participantNumber = 1;
        for (String participant : participants) {
            System.out.println(participantNumber + ". " + participant);
            participantNumber++;
        }

        System.out.println("Duplicate registrations: " + duplicateCount);

        Scanner scanner3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedTransactions = 0;

        while(scanner3.hasNextLine()) {
            String line = scanner3.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                if(inventory.containsKey(product))  {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock + quantity);
                } else {
                    inventory.put(product, quantity);
                }  
        } else if (type.equals("SELL")) {
            if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                int currentStock = inventory.get(product);
                inventory.put(product, currentStock - quantity);
            } else {
                failedTransactions++;
            }
        }

    }

        scanner3.close();
    

        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Failed sales: " + failedTransactions);

        }
    }
