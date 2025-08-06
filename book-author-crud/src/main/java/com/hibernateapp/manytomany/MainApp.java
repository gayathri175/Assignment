package com.hibernateapp.manytomany;

import com.hibernateapp.manytomany.AuthorDAO;
import com.hibernateapp.manytomany.BookDAO;
import com.hibernateapp.manytomany.Author;
import com.hibernateapp.manytomany.Book;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        AuthorDAO authorDAO = new AuthorDAO();

        while (true) {
            System.out.println("\n=== Hibernate Many-to-Many ===");
            System.out.println("1. Add Book with Authors");
            System.out.println("2. View All Books");
            System.out.println("3. View All Authors");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    Book book = new Book(title);

                    System.out.print("How many authors? ");
                    int count = sc.nextInt(); sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter author name: ");
                        String name = sc.nextLine();
                        Author author = new Author(name);
                        book.addAuthor(author);
                    }

                    bookDAO.save(book);
                    System.out.println("Book and authors saved.");
                    break;

                case 2:
                    bookDAO.getAll().forEach(b -> {
                        System.out.println(b);
                        b.getAuthors().forEach(a -> System.out.println("  Author: " + a));
                    });
                    break;

                case 3:
                    authorDAO.getAll().forEach(a -> {
                        System.out.println(a);
                        a.getBooks().forEach(b -> System.out.println("  Book: " + b));
                    });
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
