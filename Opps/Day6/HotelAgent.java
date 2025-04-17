package Day6;

import java.util.ArrayList;

public class HotelAgent extends User {

    ArrayList<Hotel> hotels = new ArrayList<>();

    HotelAgent(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }
    
}
