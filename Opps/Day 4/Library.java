import java.util.*;

public class Library {
    private String name;
    private Map<String, Book> booksByISBN;
    private Map<String, BookItem> bookItemsByBarcode;

    public Library(String name) {
        this.name = name;
        this.booksByISBN = new HashMap<>();
        this.bookItemsByBarcode = new HashMap<>();
    }

    // -------------------- Core Add Functionality --------------------

    public void addNewBookWithCopies(Book book, int numberOfCopies) {
        // Avoid duplicate books by ISBN
        if (booksByISBN.containsKey(book.getIsbn())) {
            System.out.println("Book with ISBN already exists. Use addCopiesToExistingBook() instead.");
            return;
        }

        booksByISBN.put(book.getIsbn(), book);
        for (int i = 0; i < numberOfCopies; i++) {
            String barcode = UUID.randomUUID().toString();
            BookItem bookItem = new BookItem(barcode, "RACK-DEFAULT", book); 
            book.addBookItem(bookItem);
            bookItemsByBarcode.put(barcode, bookItem);
        }
        

        System.out.println("Added book \"" + book.getTitle() + "\" with " + numberOfCopies + " copies.");
    }

    public void addCopiesToExistingBook(String isbn, int additionalCopies) {
        Book book = booksByISBN.get(isbn);
        if (book == null) {
            System.out.println(" Book with ISBN not found.");
            return;
        }
    
        for (int i = 0; i < additionalCopies; i++) {
            String barcode = UUID.randomUUID().toString();
            BookItem bookItem = new BookItem(barcode, "RACK-DEFAULT", book); 
            book.addBookItem(bookItem);
            bookItemsByBarcode.put(barcode, bookItem);
        }
    
        System.out.println("✅ Added " + additionalCopies + " copies to \"" + book.getTitle() + "\".");
    }
    

    // -------------------- Search Features --------------------

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksByISBN.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksByISBN.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    
    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksByISBN.values()) {
            if (book.getSubject().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }
    
    public List<Book> searchByPublicationDate(String date) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksByISBN.values()) {
            if (book.getPublicationDate().equalsIgnoreCase(date)) {
                result.add(book);
            }
        }
        return result;
    }

    // -------------------- Getters --------------------

    public Map<String, Book> getBooksByISBN() {
        return booksByISBN;
    }

    public Map<String, BookItem> getBookItemsByBarcode() {
        return bookItemsByBarcode;
    }

    public String getName() {
        return name;
    }
    // -------------------- Summary/Report Feature --------------------

public void printLibrarySummary() {
    System.out.println("Library Summary for: " + name);
    System.out.println("Total unique books: " + booksByISBN.size());
    System.out.println("Total book copies: " + bookItemsByBarcode.size());

    int issuedCount = 0;
    for (BookItem item : bookItemsByBarcode.values()) {
        if (item.getStatus() == BookStatus.ISSUED) {
            issuedCount++;
        }
    }

    System.out.println("Currently issued copies: " + issuedCount);

    if (issuedCount > 0) {
        System.out.println("Issued Book Details:");
        for (BookItem item : bookItemsByBarcode.values()) {
            if (item.getStatus() == BookStatus.ISSUED) {
                Member member = item.getIssuedTo();
                System.out.println("- \"" + item.getBook().getTitle() + "\" (Barcode: " + item.getBarcode() +
                        ") is with " + member.getName() + " [ID: " + member.getMemberId() + "]");
            }
        }
    } else {
        System.out.println("No books are currently issued.");
    }
}

}
