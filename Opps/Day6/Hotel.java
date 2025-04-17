package Day6;

public class Hotel {

    String name;
    String location;
    String id;
    int rating;
    Room[] rooms;
    int numberOfRooms;
    int numberOfAvailableRooms;
    HotelAgent agent;

    Hotel(String name,String loaction, String id,int numberOfRooms,HotelAgent agent){
        this.name = name;
        this.location = loaction;
        this.id = id;
        this.numberOfRooms = numberOfRooms;
        rooms = new Room[numberOfRooms];
        this.numberOfAvailableRooms = numberOfRooms;
        this.agent = agent;
        
    }



 

    
}
