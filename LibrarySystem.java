import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        HashMap<String, String> bookCatalog = new HashMap<>();
        Queue<String> borrowQueue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add book (code and title)");
            System.out.println("2. Find book by code");
            System.out.println("3. List books");
            System.out.println("4. Add borrowing request (student name and book code)");
            System.out.println("5. View next request");
            System.out.println("6. Process next request");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter book code: ");
                String code = sc.nextLine().trim().toUpperCase();
                if (code.isEmpty()) {
                    System.out.println("Code can't be blank.");
                    continue;
                }
                if (bookCatalog.containsKey(code)) {
                    System.out.println("Duplicate code! Book already exists.");
                    continue;
                }
                System.out.print("Enter book title: ");
                String title = sc.nextLine().trim();
                if (title.isEmpty()) {
                    System.out.println("Title can't be blank.");
                    continue;
                }
                bookCatalog.put(code, title);
                System.out.println("Book added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter code to search: ");
                String code = sc.nextLine().trim().toUpperCase();
                if (bookCatalog.containsKey(code)) {
                    System.out.println("Found -> Code: " + code + ", Title: " + bookCatalog.get(code));
                } else {
                    System.out.println("No book found with that code.");
                }
            } else if (choice == 3) {
                if (bookCatalog.isEmpty()) {
                    System.out.println("No books in the catalog.");
                } else {
                    for (Map.Entry<String, String> entry : bookCatalog.entrySet()) {
                        System.out.println("Code: " + entry.getKey() + " | Title: " + entry.getValue());
                    }
                }
            } else if (choice == 4) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name can't be blank.");
                    continue;
                }
                System.out.print("Enter requested book code: ");
                String code = sc.nextLine().trim().toUpperCase();
                if (!bookCatalog.containsKey(code)) {
                    System.out.println("That book code doesn't exist. Request rejected.");
                    continue;
                }
                borrowQueue.offer("Student: " + name + " | Book Code: " + code + " (" + bookCatalog.get(code) + ")");
                System.out.println("Borrowing request queued.");
            } else if (choice == 5) {
                String next = borrowQueue.peek();
                if (next == null) {
                    System.out.println("The queue is empty.");
                } else {
                    System.out.println("Next request: " + next);
                }
            } else if (choice == 6) {
                String processed = borrowQueue.poll();
                if (processed == null) {
                    System.out.println("The queue is empty. Nothing to process.");
                } else {
                    System.out.println("Processed request: " + processed);
                }
            } else if (choice == 7) {
                System.out.println("Exiting library system. Goodbye!");
            } else {
                System.out.println("Invalid choice. Pick between 1 and 7.");
            }
        }
        sc.close();
    }
}