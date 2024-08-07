import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{id='" + id + "', title='" + title + "', author='" + author + "', available=" + isAvailable + "}";
    }
}

class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "'}";
    }
}

class LibrarySystem {
    private Map<String, Book> books;
    private Map<String, User> users;
    private Map<String, String> borrowedBooks; // Book ID -> User ID

    public LibrarySystem() {
        books = new HashMap<>();
        users = new HashMap<>();
        borrowedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void listBooks() {
        System.out.println("Books in the library:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void listUsers() {
        System.out.println("Registered users:");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public void borrowBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (user == null) {
            System.out.println("User not found.");
        } else if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
        } else {
            book.setAvailable(false);
            borrowedBooks.put(bookId, userId);
            System.out.println("Book borrowed successfully.");
        }
    }

    public void returnBook(String bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isAvailable()) {
            System.out.println("Book was not borrowed.");
        } else {
            book.setAvailable(true);
            borrowedBooks.remove(bookId);
            System.out.println("Book returned successfully.");
        }
    }
}

public class Main {
    private static LibrarySystem librarySystem = new LibrarySystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some initial books and users
        librarySystem.addBook(new Book("1", "To Kill a Mockingbird", "Harper Lee"));
        librarySystem.addBook(new Book("2", "1984", "George Orwell"));
        librarySystem.addBook(new Book("3", "The Great Gatsby", "F. Scott Fitzgerald"));

        librarySystem.addUser(new User("1", "Alice"));
        librarySystem.addUser(new User("2", "Bob"));

        while (true) {
            System.out.println("Welcome to the Digital Library System");
            System.out.println("1. List Books");
            System.out.println("2. List Users");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    librarySystem.listBooks();
                    break;
                case 2:
                    librarySystem.listUsers();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        librarySystem.borrowBook(bookId, userId);
    }

    private static void returnBook() {
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        librarySystem.returnBook(bookId);
    }
}
