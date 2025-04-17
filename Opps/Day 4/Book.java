import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String bookId;
    private String title;
    private String isbn;
    private String author;
    private String subject;
    private String publicationDate;

    private List<BookItem> bookItems;

    public Book(String bookId, String title, String author, String subject, String publicationDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publicationDate = publicationDate;
        this.bookItems = new ArrayList<>();
    }

    // Add a physical copy to this book
    public void addBookItem(BookItem item) {
        bookItems.add(item);
    }

 
    // Getters
    public List<BookItem> getAvailableItems() {
        return bookItems.stream()
                .filter(BookItem::isAvailable)
                .collect(Collectors.toList());
    }

    public int getTotalCopies() {
        return bookItems.size();
    }

    public int getTotalAvailable() {
        return getAvailableItems().size();
    }

    public String getBookId() {
        return bookId;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public List<BookItem> getBookItems() {
        return bookItems;
    }
}
