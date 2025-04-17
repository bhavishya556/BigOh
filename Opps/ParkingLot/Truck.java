package ParkingLot;


public class Truck extends Vehicle {
    public Truck(String licensePlate,long entryTime) {
        super(licensePlate, VehicleType.TRUCK,entryTime);
    }
}
