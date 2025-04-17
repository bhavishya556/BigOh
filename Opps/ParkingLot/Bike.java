package ParkingLot;

import java.time.LocalDateTime;

public class Bike extends Vehicle {
    public Bike(String licensePlate,long entryTime) {
        super(licensePlate, VehicleType.BIKE,entryTime);
    }
}
