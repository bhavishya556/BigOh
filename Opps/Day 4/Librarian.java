import java.util.*;

public class Librarian extends Member {

    public Librarian(String memberId, String name, String email, String phone) {
        super(memberId, name, email, phone);
    }

    // Add a new book to the catalog
    public void addBook(Book book, Map<String, Book> booksByISBN) {
        if (booksByISBN.containsKey(book.getBookId())) {
            System.out.println(" Book with ISBN already exists.");
        } else {
            booksByISBN.put(book.getBookId(), book);
            System.out.println("📘 Book added: " + book.getTitle());
        }
    }

    // Add a new physical copy of an existing book
    public void addBookItem(Book book, BookItem item, Map<String, BookItem> bookItemsByBarcode) {
        book.addBookItem(item);
        bookItemsByBarcode.put(item.getBarcode(), item);
        System.out.println("New copy added with barcode: " + item.getBarcode());
    }

    // Remove a book from catalog
    public void removeBook(String isbn, Map<String, Book> booksByISBN, Map<String, BookItem> bookItemsByBarcode) {
        Book book = booksByISBN.remove(isbn);
        if (book != null) {
            // Remove associated book items
            for (BookItem item : book.getBookItems()) {
                bookItemsByBarcode.remove(item.getBarcode());
            }
            System.out.println("Book and all copies removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Register a new member
    public void registerMember(Member member, Map<String, Member> membersById) {
        membersById.put(member.getMemberId(), member);
        System.out.println("Member registered: " + member.getName());
    }

    // Cancel membership
    public void cancelMembership(String memberId, Map<String, Member> membersById) {
        if (membersById.remove(memberId) != null) {
            System.out.println(" Member with ID " + memberId + " removed.");
        } else {
            System.out.println("Member not found.");
        }
    }
}
