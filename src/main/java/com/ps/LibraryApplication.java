package com.ps;

import java.util.Scanner;

public class LibraryApplication {
    private static final int INVENTORY_SIZE = 20;
    private static Book[] inventory = new Book[INVENTORY_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        populateInventory(); // Initialize the book inventory

        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to the Neighborhood Library");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    showAvailableBooks(scanner);
                    break;
                case 2:
                    showCheckedOutBooks(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    // This method initializes the book inventory with some books
    private static void populateInventory() {
        for (int i = 0; i < INVENTORY_SIZE; i++) {
            inventory[i] = new Book(i, "ISBN" + i, "Title" + i);
        }
    }

    // This method shows all available books that are not checked out
    private static void showAvailableBooks(Scanner scanner) {
        System.out.println("Available Books:");
        for (Book book : inventory) {
            if (!book.isIsCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle());
            }
        }
        System.out.print("Enter the ID of the book to check out or -1 to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (bookId >= 0 && bookId < INVENTORY_SIZE) {
            if (!inventory[bookId].isIsCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                inventory[bookId].checkOut(name);
                System.out.println("Book checked out successfully!");
            } else {
                System.out.println("This book is already checked out.");
            }
        }
    }

    private static void showCheckedOutBooks(Scanner scanner) {
        System.out.println("Checked Out Books:");
        for (Book book : inventory) {
            if (book.isIsCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() +
                        ", Checked out to: " + book.getCheckedOutTo());
            }
        }

        System.out.println("Enter 'C' to check in a book or 'X' to return to the home screen:");
        String input = scanner.nextLine().trim().toUpperCase(); // Make sure it's uppercase for consistency

        if (input.equals("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (bookId >= 0 && bookId < INVENTORY_SIZE && inventory[bookId].isIsCheckedOut()) {
                inventory[bookId].checkIn();
                System.out.println("Book checked in successfully!");
            } else {
                System.out.println("Invalid book ID or the book is not checked out.");
            }
        } else if (!input.equals("X")) {
            System.out.println("Invalid input. Please try again.");

        }

    }
}