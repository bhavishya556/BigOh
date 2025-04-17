import java.time.LocalDate;

public class BookItem {
    private final String barcode;
    private final String rackNumber;
    private BookStatus status;
    private LocalDate dueDate;
    private final Book book;
    private Member issuedTo; 

    // Constructor (with default AVAILABLE status)
    public BookItem(String barcode, String rackNumber, Book book) {
        this.barcode = barcode;
        this.rackNumber = rackNumber;
        this.book = book;
        this.status = BookStatus.AVAILABLE;
        this.dueDate = null;
    }

    // overloaded constructor 
    public BookItem(String barcode, String rackNumber, Book book, BookStatus status) {
        this.barcode = barcode;
        this.rackNumber = rackNumber;
        this.book = book;
        this.status = status;
        this.dueDate = null;
    }

    // Getters
    public String getBarcode() {
        return barcode;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public BookStatus getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return this.status == BookStatus.AVAILABLE;
    }

    // Operations
    public void checkOut(LocalDate dueDate) {
        if (isAvailable()) {
            this.status = BookStatus.ISSUED;
            this.dueDate = dueDate;
         
        } else {
            System.out.println("BookItem not available for checkout.");
        }
    }
    
    public Member getIssuedTo() {
        return issuedTo; // ✅ Add this method
    }

    public void returnBook() {
        this.status = BookStatus.AVAILABLE;
        this.dueDate = null;
    }

    public void reserve() {
        if (isAvailable()) {
            this.status = BookStatus.RESERVED;
        } else {
            System.out.println("Cannot reserve. Book is not available.");
        }
    }

    public void markLost() {
        this.status = BookStatus.LOST;
        this.dueDate = null;
    }
}
