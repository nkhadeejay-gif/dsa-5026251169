package lw03.unguided;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scReg = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Scanner scCheck = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> registered = new LinkedHashSet<>();
        Set<String> checkIn = new HashSet<>();
        List<String> output = new LinkedList<>();
        int rejectedAttempts = 0;

        while (scReg.hasNext()) {
            String student = scReg.next();
            if (registered.add(student)) {
            }
        }
        
        scReg.close();

        while (scCheck.hasNext()) {
            String student = scCheck.next();
            if (!registered.contains(student)) {
                output.add(student + ": Rejected (Not Registered)");
                rejectedAttempts++;
            } else if (checkIn.contains(student)) {
                output.add(student + ": Rejected (Already Checked In)");
                rejectedAttempts++;
            } else {
                checkIn.add(student);
                output.add(student + ": Checked In");
            }
        }
            scCheck.close();

        System.out.println("===== Event Check-In Results =====");
        for (String result : output) {
            System.out.println(result);
        }

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered.size());
        System.out.println("Successful check-ins: " + checkIn.size());
        System.out.println("Absent students: " + (registered.size() - checkIn.size()));
        System.out.println("Rejected attempts: " + rejectedAttempts);
    }
}
