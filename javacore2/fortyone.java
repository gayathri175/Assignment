package practice2;


import java.util.*;

class BookStore {
    private int bookId;
    private String bookName;

    public BookStore(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String toString() {
        return bookId + " - " + bookName;
    }
}

class BookNameComparator implements Comparator<BookStore> {
    public int compare(BookStore b1, BookStore b2) {
        return b1.getBookName().compareTo(b2.getBookName());
    }
}

class BookIdComparator implements Comparator<BookStore> {
    public int compare(BookStore b1, BookStore b2) {
        return Integer.compare(b1.getBookId(), b2.getBookId());
    }
}

public class fortyone {

    public static void main(String[] args) {
        List<BookStore> books = new ArrayList<>();
        books.add(new BookStore(103, "Java Basics"));
        books.add(new BookStore(101, "Data Structures"));
        books.add(new BookStore(102, "Algorithms"));

        System.out.println("Sorted by Book Name:");
        Collections.sort(books, new BookNameComparator());
        for (BookStore b : books) {
            System.out.println(b);
        }

        System.out.println("\nSorted by Book ID:");
        Collections.sort(books, new BookIdComparator());
        for (BookStore b : books) {
            System.out.println(b);
        }
    }
}
/*Sorted by Book Name:
102 - Algorithms
101 - Data Structures
103 - Java Basics

Sorted by Book ID:
101 - Data Structures
102 - Algorithms
103 - Java Basics
*/