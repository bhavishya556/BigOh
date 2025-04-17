package ParkingLot;

import java.time.LocalDateTime;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;
      protected Long entryTime; 

      public Vehicle(String licensePlate, VehicleType type, long entryTime) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.entryTime = entryTime;
    }
    

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public long getEntryTime() {
        
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
}


