import java.util.ArrayList;
import java.util.Scanner;

// Nama: Muhammad Ardho Rantisy
// NPM: 2210631170082
// Kelas: 3C Informatika

abstract class Book {
    private String title;
    private String author;
    private int year;
    private String genre;

    public Book(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public abstract void displayDetails();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }
}

class ActionBook extends Book {
    public ActionBook(String title, String author, int year) {
        super(title, author, year, "Action");
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() + ", Genre: " + getGenre());
    }
}

class HorrorBook extends Book {
    public HorrorBook(String title, String author, int year) {
        super(title, author, year, "Horror");
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() + ", Genre: " + getGenre());
    }
}

class RomanceBook extends Book {
    public RomanceBook(String title, String author, int year) {
        super(title, author, year, "Romance");
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() + ", Genre: " + getGenre());
    }
}

class MysteryBook extends Book {
    public MysteryBook(String title, String author, int year) {
        super(title, author, year, "Mystery");
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() + ", Genre: " + getGenre());
    }
}

class HumorBook extends Book {
    public HumorBook(String title, String author, int year) {
        super(title, author, year, "Humor");
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() + ", Genre: " + getGenre());
    }
}

class User {
    public void viewBooks(ArrayList<Book> books) {
        System.out.println("---- Available Books ----");
        for (Book book : books) {
            book.displayDetails();
        }
    }
}

class Admin extends User {
    public void addBook(ArrayList<Book> books, Book newBook) {
        books.add(newBook);
        System.out.println("Book added successfully.");
    }

    public void deleteBook(ArrayList<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("Nama: Muhammad Ardho Rantisy");
        System.out.println("NPM: 2210631170082");
        System.out.println("Kelas: 3C Informatika");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        Admin admin = new Admin();
        User user = new User();

        while (true) {
            System.out.println("\n----- Sistem Pengelolaan Perpustakaan (Full Engrish) -----");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n----- Admin Menu -----");
                    System.out.println("1. Add Book");
                    System.out.println("2. View Books");
                    System.out.println("3. Delete Book");
                    System.out.println("4. Exit");

                    System.out.print("Enter your choice: ");
                    int adminChoice = scanner.nextInt();

                    switch (adminChoice) {
                        case 1:
                            System.out.print("Enter title: ");
                            String title = scanner.next();
                            System.out.print("Enter author: ");
                            String author = scanner.next();
                            System.out.print("Enter year of publication: ");
                            int year = scanner.nextInt();
                            System.out.print("Enter genre (Action, Horror, Romance, Mystery, Humor): ");
                            String genre = scanner.next();

                            Book newBook;
                            switch (genre.toLowerCase()) {
                                case "action":
                                    newBook = new ActionBook(title, author, year);
                                    break;
                                case "horror":
                                    newBook = new HorrorBook(title, author, year);
                                    break;
                                case "romance":
                                    newBook = new RomanceBook(title, author, year);
                                    break;
                                case "mystery":
                                    newBook = new MysteryBook(title, author, year);
                                    break;
                                case "humor":
                                    newBook = new HumorBook(title, author, year);
                                    break;
                                default:
                                    System.out.println("Invalid genre. Book not added.");
                                    continue;
                            }

                            admin.addBook(books, newBook);
                            break;

                        case 2:
                            admin.viewBooks(books);
                            break;

                        case 3:
                            System.out.print("Enter the title of the book to delete: ");
                            String deleteTitle = scanner.next();
                            admin.deleteBook(books, deleteTitle);
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n----- User Menu -----");
                    System.out.println("1. View Books");
                    System.out.println("2. Exit");

                    System.out.print("Enter your choice: ");
                    int userChoice = scanner.nextInt();

                    switch (userChoice) {
                        case 1:
                            user.viewBooks(books);
                            break;

                        case 2:
                            break;

                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Keluar Sistem. byww :3");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}