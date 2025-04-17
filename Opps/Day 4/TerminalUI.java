import java.time.LocalDate;
import java.util.*;

public class TerminalUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Member> members = new HashMap<>();
    private static final Map<String, Book> booksByISBN = new HashMap<>();
    private static final Map<String, BookItem> bookItemsByBarcode = new HashMap<>();
    private static final NotificationService notifier = new NotificationService();

    public static void main(String[] args) {
        Librarian librarian = new Librarian("admin01", "Librarian", "lib@example.com", "9999999999");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook(librarian);
                case 2 -> addCopies(librarian);
                case 3 -> registerMember(librarian);
                case 4 -> checkoutBook();
                case 5 -> returnBook();
                case 6 -> reserveBook();
                case 7 -> searchByCategory();
                case 0 -> running = false;
                default -> System.out.println(" Invalid choice");
            }
        }

        System.out.println("Exiting Library System");
    }

    private static void printMenu() {
        System.out.println("\n Library System - Menu:");
        System.out.println("1. Add new book");
        System.out.println("2. Add copies to existing book");
        System.out.println("3. Register member");
        System.out.println("4. Checkout book");
        System.out.println("5. Return book");
        System.out.println("6. Reserve book");
        System.out.println("7. Search books by category");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook(Librarian librarian) {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Publication Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Book book = new Book(isbn, title, author, subject, date);
        booksByISBN.put(isbn, book);
        System.out.println("✅ Book added successfully.");
    }

    private static void addCopies(Librarian librarian) {
        System.out.print("Enter ISBN of existing book: ");
        String isbn = scanner.nextLine();

        Book book = booksByISBN.get(isbn);
        if (book == null) {
            System.out.println(" Book not found.");
            return;
        }

        System.out.print("Enter number of copies: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            String barcode = UUID.randomUUID().toString();
            System.out.println("your book barcode is: " + barcode);
            BookItem item = new BookItem(barcode, "RACK-DEFAULT", book);
            book.addBookItem(item);
            bookItemsByBarcode.put(barcode, item);
        }

        System.out.println("✅ Added " + count + " copies to " + book.getTitle());
    }

    private static void registerMember(Librarian librarian) {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Member member = new Member(id, name, email, phone);
        members.put(id, member);
        System.out.println("✅ Member registered.");
    }

    private static void checkoutBook() {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter Book Barcode: ");
        String barcode = scanner.nextLine();
        BookItem item = bookItemsByBarcode.get(barcode);
        if (item == null) {
            System.out.println(" Book item not found.");
            return;
        }

        member.checkOutBook(item, LocalDate.now());
        notifier.notifyDueDate(member, item);
    }

    private static void returnBook() {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println(" Member not found.");
            return;
        }

        System.out.print("Enter Book Barcode: ");
        String barcode = scanner.nextLine();
        BookItem item = bookItemsByBarcode.get(barcode);
        if (item == null) {
            System.out.println(" Book item not found.");
            return;
        }

        member.returnBook(item, LocalDate.now());
    }

    private static void reserveBook() {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println(" Member not found.");
            return;
        }

        System.out.print("Enter Book Barcode: ");
        String barcode = scanner.nextLine();
        BookItem item = bookItemsByBarcode.get(barcode);
        if (item == null) {
            System.out.println(" Book item not found.");
            return;
        }

        member.reserveBook(item);
        notifier.notifyReservation(member, item);
    }

    private static void searchByCategory() {
        System.out.print("Enter category/subject: ");
        String category = scanner.nextLine();

        List<Book> results = booksByISBN.values()
                .stream()
                .filter(b -> b.getSubject().equalsIgnoreCase(category))
                .toList();

        if (results.isEmpty()) {
            System.out.println(" No books found in this category.");
        } else {
            System.out.println(" Books in '" + category + "':");
            for (Book book : results) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
