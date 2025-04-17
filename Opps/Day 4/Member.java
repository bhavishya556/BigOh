import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberId;
    private final String name;
    private final String email;
    private final String phone;

    private final List<BookItem> checkedOutBooks;
    private final List<BookItem> reservedBooks;

    private static final int MAX_BOOKS_ALLOWED = 5;
    private static final int MAX_DAYS_ALLOWED = 10;
    private static final double FINE_PER_DAY = 2.0;

    public Member(String memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.checkedOutBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public boolean checkOutBook(BookItem item, LocalDate today) {
        if (checkedOutBooks.size() >= MAX_BOOKS_ALLOWED) {
            System.out.println(" Max limit reached. Cannot borrow more books.");
            return false;
        }
        if (!item.isAvailable()) {
            System.out.println(" Book is not available.");
            return false;
        }

        LocalDate dueDate = today.plusDays(MAX_DAYS_ALLOWED);
        item.checkOut(dueDate);
        checkedOutBooks.add(item);
        System.out.println("✅ Book checked out. Due on " + dueDate);
        return true;
    }

    public boolean returnBook(BookItem item, LocalDate today) {
        if (!checkedOutBooks.contains(item)) {
            System.out.println(" This book was not borrowed by the member.");
            return false;
        }

        checkedOutBooks.remove(item);
        if (item.getDueDate() != null && today.isAfter(item.getDueDate())) {
            long lateDays = today.toEpochDay() - item.getDueDate().toEpochDay();
            double fine = lateDays * FINE_PER_DAY;
            System.out.println("⚠️ Book returned late. Fine: ₹" + fine);
        }

        item.returnBook();
        System.out.println("✅ Book returned.");
        return true;
    }

    public boolean reserveBook(BookItem item) {
        if (!item.isAvailable()) {
            System.out.println(" Book not available for reservation.");
            return false;
        }

        item.reserve();
        reservedBooks.add(item);
        System.out.println("✅ Book reserved.");
        return true;
    }

    public boolean renewBook(BookItem item, LocalDate today) {
        if (!checkedOutBooks.contains(item)) {
            System.out.println(" This book is not checked out by you.");
            return false;
        }

        LocalDate newDueDate = today.plusDays(MAX_DAYS_ALLOWED);
        item.checkOut(newDueDate);
        System.out.println("🔁 Book renewed. New due date: " + newDueDate);
        return true;
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
    // public String getMemberId() {
    //     return name;
    // }


    public List<BookItem> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public List<BookItem> getReservedBooks() {
        return reservedBooks;
    }
    
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }    

    @Override
    public String toString() {
        return "👤 Member: " + name + " (ID: " + memberId + ")";
    }
}
