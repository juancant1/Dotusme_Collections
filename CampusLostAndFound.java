import java.util.ArrayList;
import java.util.Scanner;

public class CampusLostAndFound {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 6) {
            System.out.println("\n--- Campus Lost-and-Found Tracker ---");
            System.out.println("1. Add an item description");
            System.out.println("2. View all reports with numbered positions");
            System.out.println("3. Search reports by a keyword");
            System.out.println("4. Remove a report by its displayed number");
            System.out.println("5. Show total reports");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;
            
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
            
            if (choice == 1) {
                System.out.print("Enter item description: ");
                String desc = sc.nextLine().trim();
                if (!desc.isEmpty()) {
                    items.add(desc);
                    System.out.println("Item added successfully.");
                } else {
                    System.out.println("Description cannot be empty.");
                }
            } else if (choice == 2) {
                if (items.isEmpty()) {
                    System.out.println("No reports currently recorded.");
                } else {
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i + 1) + ". " + items.get(i));
                    }
                }
            } else if (choice == 3) {
                if (items.isEmpty()) {
                    System.out.println("No reports available to search.");
                    continue;
                }
                System.out.print("Enter keyword to search: ");
                String kw = sc.nextLine().trim().toLowerCase();
                boolean found = false;
                
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).toLowerCase().contains(kw)) {
                        System.out.println((i + 1) + ". " + items.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No reports matched that keyword.");
                }
            } else if (choice == 4) {
                if (items.isEmpty()) {
                    System.out.println("No reports to remove.");
                    continue;
                }
                System.out.print("Enter report number to remove: ");
                try {
                    int pos = Integer.parseInt(sc.nextLine().trim());
                    if (pos >= 1 && pos <= items.size()) {
                        String removed = items.remove(pos - 1);
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("Invalid position number.");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                }
            } else if (choice == 5) {
                System.out.println("Total reports recorded: " + items.size());
            } else if (choice == 6) {
                System.out.println("Exiting tracker. Goodbye!");
            } else {
                System.out.println("Invalid choice. Pick between 1 and 6.");
            }
        }
        sc.close();
    }
}