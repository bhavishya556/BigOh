public class NotificationService {

    public void sendEmail(String email, String subject, String message) {
        // In a real system, this would integrate with an email provider
        System.out.println("📧 Email sent to " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }

    public void sendSMS(String phoneNumber, String message) {
        // In real use, integrate with SMS gateway API
        System.out.println("📱 SMS sent to " + phoneNumber);
        System.out.println("Message: " + message);
    }

    public void notifyDueDate(Member member, BookItem item) {
        String subject = "Book Due Reminder: " + item.getBook().getTitle();
        String message = "Your book \"" + item.getBook().getTitle() + "\" is due on " + item.getDueDate() + ".";
        sendEmail(member.getEmail(), subject, message);
    }

    public void notifyReservation(Member member, BookItem item) {
        String subject = "Book Reservation Confirmed";
        String message = "You have reserved the book: " + item.getBook().getTitle() + ".";
        sendEmail(member.getEmail(), subject, message);
    }

    public void notifyFine(Member member, double fineAmount) {
        String subject = "Library Fine Alert";
        String message = "You have a pending fine of ₹" + fineAmount + ". Please clear it at the library.";
        sendEmail(member.getEmail(), subject, message);
    }
}
