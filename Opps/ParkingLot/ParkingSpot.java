package ParkingLot;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public Vehicle unpark() {
        if (!isOccupied) return null;
        Vehicle vehicle = this.parkedVehicle;
        this.parkedVehicle = null;
        this.isOccupied = false;
        return vehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    
public void leave() {
    this.isOccupied = false;
    this.parkedVehicle = null;
}
}
