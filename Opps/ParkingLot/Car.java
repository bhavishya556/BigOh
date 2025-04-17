package ParkingLot;
import java.time.LocalDateTime;
public class Car extends Vehicle {
    public Car(String licensePlate, long entryTime) {
        super(licensePlate, VehicleType.CAR, entryTime);
    }
}

