import java.util.HashSet;
import java.util.Scanner;

public class ClubEventCodes {
    public static void main(String[] args) {
        HashSet<String> codes = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n--- Club Membership and Event Codes ---");
            System.out.println("1. Register event code");
            System.out.println("2. View all unique codes");
            System.out.println("3. Check whether a code exists");
            System.out.println("4. Remove a code");
            System.out.println("5. Show total unique codes");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            try {
                choice = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Invalid input format.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter event code: ");
                    String c = sc.nextLine().trim().toUpperCase();
                    if (c.isEmpty()) {
                        System.out.println("Code cannot be blank.");
                    } else if (codes.add(c)) {
                        System.out.println("Event code registered successfully.");
                    } else {
                        System.out.println("Duplicate code! It's already registered.");
                    }
                    break;
                case 2:
                    if (codes.isEmpty()) {
                        System.out.println("No event codes registered yet.");
                    } else {
                        System.out.println("Registered Codes (Order is not guaranteed):");
                        for (String code : codes) {
                            System.out.println("- " + code);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter code to check: ");
                    String check = sc.nextLine().trim().toUpperCase();
                    if (codes.contains(check)) {
                        System.out.println("Yes, that code exists in the system.");
                    } else {
                        System.out.println("No, that code does not exist.");
                    }
                    break;
                case 4:
                    System.out.print("Enter code to remove: ");
                    String rem = sc.nextLine().trim().toUpperCase();
                    if (codes.remove(rem)) {
                        System.out.println("Code removed successfully.");
                    } else {
                        System.out.println("Code not found.");
                    }
                    break;
                case 5:
                    System.out.println("Total unique codes: " + codes.size());
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Please pick a number from 1 to 6.");
            }
        }
        sc.close();
    }
}