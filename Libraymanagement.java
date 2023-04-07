import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int isbn;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return isbn;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN() == isbn) {
                books.remove(i);
                break;
            }
        }
    }

    public void displayBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Title: " + books.get(i).getTitle() +
                    ", Author: " + books.get(i).getAuthor() +
                    ", ISBN: " + books.get(i).getISBN());
        }
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter book author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter book ISBN:");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.println("Enter book ISBN to remove:");
                    int isbnToRemove = scanner.nextInt();
                    scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }
}
