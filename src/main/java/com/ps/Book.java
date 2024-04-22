package com.ps;

public class Book {
    // Instance variables
    private int id; // Unique identifier for each book
    private String isbn; // International Standard Book Number
    private String title; // Title of the book
    private boolean isCheckedOut; // Flag to check if the book is checked out
    private String checkedOutTo; // Name of the person who has checked out the book

    // Constructor to create a new Book
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        // When a new book is created, it is not checked out
        this.isCheckedOut = false;
        this.checkedOutTo = ""; // No one has checked it out yet
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIsCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Method to check out a book
    public void checkOut(String name) {
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
        } else {
            System.out.println("The book is already checked out.");
        }
    }

    // Method to check in a book
    public void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
    }
}
