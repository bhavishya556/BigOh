package Day6;

import java.time.LocalDate;

public class Booking {

    private User user;
    private String hotelId;
    private LocalDate bookingDate;
    private LocalDate checkOutDate;

    public Booking(User user, String hotelId) {
        this.user = user;
        this.hotelId = hotelId;
        this.bookingDate = LocalDate.now(); 
    }

    // Getters
    public User getUser() {
        return user;
    }

    public String getHotelId() {
        return hotelId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    // Setter for checkOutDate
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

}
