package Day6;

import java.util.ArrayList;

class HotelManagement {

   
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Hotel> pendingHotels = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private  Administrator administrator ;


    public User createUser(String name, String email, String phoneNumber){
        User user = new User(name, email, phoneNumber);
        users.add(user);
        return user;
    }

    public HotelAgent createHotelAgent(String name, String email, String phoneNumber) {
        HotelAgent hotelAgent = new HotelAgent(name, email, phoneNumber);
        return hotelAgent;
    }

    public Administrator createAdministrator(String name, String email, String phoneNumber) {

        administrator = new Administrator(name, email, phoneNumber);
        return administrator;
    }

    public Administrator getAdmin() {
        return administrator;
    }

    public boolean isAdminAvaliable() {
        return(administrator != null) ? true : false;
    }

    public void addHotel(Hotel hotel) {
        if (hotel.agent instanceof HotelAgent hotelAgent) {
            pendingHotels.add(hotel);
            System.out.println("Hotel added to pending list for approval by "+hotelAgent.name);
        } else {
            System.out.println("only hotel agent can add ");
        }
    }
    
    public void removeHotel(User user, Hotel hotel) {
        if (user instanceof Administrator admin) {
            pendingHotels.remove(hotel);
            System.out.println("Hotel removed to pending list for approval by "+admin.name);
        } else {
            System.out.println("only admin can remove ");
        }
    }

    public void approveHotel(User user, String hotelId, boolean isApprove) {
        if (user instanceof Administrator admin) {
            Hotel hotelToApprove = null;
    
            for (Hotel pendingHotel : pendingHotels) {
                if (pendingHotel.id.equals(hotelId)) {
                    hotelToApprove = pendingHotel;
                    break;
                }
            }
    
            if (hotelToApprove != null) {
                pendingHotels.remove(hotelToApprove);
                if (isApprove) {
                    hotels.add(hotelToApprove);
                    System.out.println(hotelToApprove.name+" Hotel is Approved by " + admin.name);
                } else {
                    System.out.println(hotelToApprove.name+" Hotel was rejected by " + admin.name);
                }
            } else {
                System.out.println("Hotel ID not found in pending list.");
            }
    
        } else {
            System.out.println("Only administrator can approve.");
        }
    }
    
    public void showAllHotels(){
        int i =1;
        System.out.println("All hotels");
        for(Hotel hotel : hotels ){
         
            System.out.println(i+" ) "+hotel.name+" ");
            System.out.println("room avaliable : "+ hotel.numberOfAvailableRooms);
            System.out.println("Loacation : "+ hotel.location);
            System.out.println("Hotel id : "+ hotel.id);
            System.out.println("_______________________________");
            System.out.println();
            i++;
        }
    }

    public void showAllPendingHotels(){
        int i =1;
        System.out.println("All hotels");
        for(Hotel hotel : pendingHotels){
         
            System.out.println(i+" ) "+hotel.name+" ");
            System.out.println("room avaliable : "+ hotel.numberOfAvailableRooms);
            System.out.println("Loacation : "+ hotel.location);
            System.out.println("Hotel id : "+ hotel.id);
            System.out.println("_______________________________");
            System.out.println();
            i++;
        }
    }
    
    public void bookHootel(User user, String hotelId){

        if (user instanceof User customer) {

            for (Hotel hotel : hotels) {
                if (hotel.id.equals(hotelId)) {
                    if(hotel.numberOfAvailableRooms>0){
                        bookings.add(new Booking(user, hotelId));
                        hotel.numberOfAvailableRooms = hotel.numberOfAvailableRooms -1;
                        System.out.println("Booking sucessfully");

                    }else{
                        System.out.println(customer.name+" no room avaliable in this hotel");
                    }
                   
                }
            }
    

          
        } else {
            System.out.println("only user can book hotel");
        }

    }

    public Hotel getHotelFromId(String id){
        Hotel hotleToReturn = null;
        for(Hotel hotel: hotels){
            if(id.equals(hotel.id)){
                hotleToReturn = hotel;
                
            }
        }
        return hotleToReturn;
    }

    public void showAllBookings(){
        System.out.println("----show all bookings-------");
        for(Booking booking : bookings){
            System.out.println( );
            System.out.println("customer Name : "+ booking.getUser().name);
            String hotelId = booking.getHotelId();
            Hotel hotel = getHotelFromId(hotelId);
            System.out.println("Hotel Name : "+ hotel.name);
            System.out.println( );
            System.out.println("Hotel id : "+ hotel.id);
            System.out.println("----------------------");

        }
    } 

    public void hotelBookingsByHotelId(String hotelId) {
        Hotel hotel = getHotelFromId(hotelId);
    
        if (hotel == null) {
            System.out.println("No bookings found for this hotel.");
            return;
        }
    
        System.out.println("---- Show all bookings for " + hotel.name + " ----");
    
        boolean foundBooking = false;
        for (Booking booking : bookings) {
            if (booking.getHotelId().equals(hotelId)) {
                foundBooking = true;
                System.out.println();
                System.out.println("Customer Name: " + booking.getUser().name);
                System.out.println("Hotel Name: " + hotel.name);
                System.out.println("Booking Date: " + booking.getBookingDate());
                System.out.println("Check-out Date: " + booking.getCheckOutDate());
                System.out.println("----------------------");
            }
        }
    
        if (!foundBooking) {
            System.out.println("No bookings found for this hotel.");
        }
    }
 
    public HotelAgent findAgentByName(String name) {
        System.out.println(name);
        for (Hotel hotel : hotels) {
            System.out.println(hotel.agent.name);
            if (hotel.agent.name.equals(name)) {
                System.out.println(hotel.agent.name);
                return hotel.agent;
            }
        }
        return null;
    }

    public User findUserByName(String name) {
        for (User u : users) {
            if (u.name.equals(name)) return u;
        }
        return null;
    }
    
    
    
}
