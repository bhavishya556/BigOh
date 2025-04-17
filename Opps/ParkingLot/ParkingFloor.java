package ParkingLot;

import java.util.*;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<VehicleType, Integer> totalSpaces;
    private final Map<VehicleType, Integer> availableSpaces;
    private final Map<Integer, ParkingSpot> spotMap; // spotNumber -> ParkingSpot

    private int nextSpotNumber = 1; // for auto-incrementing spot numbers

    public ParkingFloor(int floorNumber, Map<VehicleType, Integer> spaceConfig) {
        this.floorNumber = floorNumber;
        this.totalSpaces = new HashMap<>(spaceConfig);
        this.availableSpaces = new HashMap<>(spaceConfig);
        this.spotMap = new HashMap<>();

        
        for (Map.Entry<VehicleType, Integer> entry : spaceConfig.entrySet()) {
            VehicleType type = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                ParkingSpot spot = new ParkingSpot(nextSpotNumber++, type);
                spotMap.put(spot.getSpotNumber(), spot);
            }
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        if (availableSpaces.getOrDefault(type, 0) > 0) {
            for (ParkingSpot spot : spotMap.values()) {
                if (!spot.isOccupied() && spot.getVehicleType() == type) {
                    spot.park(vehicle); // ✅ pass vehicle here
                    availableSpaces.put(type, availableSpaces.get(type) - 1);
                    System.out.println("✅ " + type + " parked at Spot " + spot.getSpotNumber() + " on Floor " + floorNumber);
                    return true;
                }
            }
        }
        return false;
    }
    

    public ParkingSpot getSpotByNumber(int spotNumber) {
        return spotMap.get(spotNumber);
    }
    
    
    
    public Vehicle leaveSpot(int spotNumber) {
        ParkingSpot spot = spotMap.get(spotNumber);
        if (spot != null && spot.isOccupied()) {
            Vehicle vehicle = spot.getParkedVehicle(); // get the vehicle before removing
            spot.leave();
            VehicleType type = spot.getVehicleType();
            availableSpaces.put(type, availableSpaces.getOrDefault(type, 0) + 1);
            System.out.println("Spot " + spotNumber + " is now free.");
            return vehicle;
        } else {
            System.out.println("Invalid or already empty spot: " + spotNumber);
            return null;
        }
    }
    
    

    public void printAvailability() {
        System.out.println("Availability on Floor " + floorNumber + ":");
        for (VehicleType type : availableSpaces.keySet()) {
            System.out.println(type + ": " + availableSpaces.get(type) + " available out of " + totalSpaces.get(type));
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

  
    public void updateSpaces(Map<VehicleType, Integer> newConfig) {
        totalSpaces.clear();
        availableSpaces.clear();
        spotMap.clear();
        nextSpotNumber = 1;

        totalSpaces.putAll(newConfig);
        availableSpaces.putAll(newConfig);

        for (Map.Entry<VehicleType, Integer> entry : newConfig.entrySet()) {
            VehicleType type = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                ParkingSpot spot = new ParkingSpot(nextSpotNumber++, type);
                spotMap.put(spot.getSpotNumber(), spot);
            }
        }

        System.out.println("✅ Floor " + floorNumber + " layout updated.");
    }
}


