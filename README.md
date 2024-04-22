# Neighborhood Library Management System

This application serves as a management system for a neighborhood library, allowing users to check out and return books. It's designed with simplicity in mind, offering an easy-to-navigate interface for both librarians and patrons.

## Features

- **Home Screen**: The starting point of the application, where users can select different options.
- **Book Display**: View all available books or those currently checked out.
- **Error Handling**: The system gracefully handles erroneous inputs by prompting the user with descriptive error messages.

## Interesting Piece of Code

One interesting piece of code is the function to check out a book:

```java
public void checkOut(String name) {
    if (!isCheckedOut) {
        isCheckedOut = true;
        checkedOutTo = name;
        System.out.println("Book checked out successfully!");
    } else {
        System.out.println("This book is already checked out.");
    }
}

```
This function is interesting to me because it encapsulates the essential feature of the library system while ensuring that the same book cannot be checked out by more than one person at a time. The simplicity and elegance of this logic highlight the power of object-oriented programming in handling real-world scenarios.
