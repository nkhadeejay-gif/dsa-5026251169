package lw04.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        int n = scanner.nextInt();
        int[] parcels = new int[n];

        for (int i = 0; i < n; i++) {
            parcels[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = scanner.nextInt();
        }

        scanner.close();

        bubbleSort(parcels, 2);
        int[] twoPasses = new int[n];
        for (int i = 0; i < n; i++) {
            twoPasses[i] = parcels[i];
        }

        bubbleSort(parcels, n - 3);
        System.out.println("==== After 2 Passes ====");
        displayArray(twoPasses);

        System.out.println();

        System.out.println("==== Fully Sorted ====");
        displayArray(parcels);

        System.out.println();

        System.out.println("==== Search Results ====");

        for (int i = 0; i < m; i++) {
            int[] result = binarySearch(parcels, targets[i]);
            int index = result[0];
            int steps = result[1];

            if (index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index + " (steps: " + steps + ")");
            } else {
                System.out.println(targets[i] + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }   
    static void bubbleSort(int[] arr, int passes) {
        int n = arr.length;
        for (int i = 0; i < passes; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static int[] binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int steps = 0;

        while (low <= high) {
            int mid = (low+high) / 2;
            steps++;

            if (arr[mid] == target) {
                return new int[]{mid, steps};
            } else if (arr[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, steps};
    }

    static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
