package ParkingLot;

import java.util.*;

public class ParkingLot {

    private final List<ParkingFloor> floors;

    public ParkingLot() {
        this.floors = new ArrayList<>();
    }

    public void addFloor(User user, int floorNumber, Map<VehicleType, Integer> vehicleSpaceConfig) {
        if (user instanceof Admin admin) {
            ParkingFloor newFloor = new ParkingFloor(floorNumber, vehicleSpaceConfig);
            floors.add(newFloor);
            System.out.println("✅ Floor " + floorNumber + " added by Admin: " + admin.getName());
        } else {
            System.out.println("❌ Only admins can add floors.");
        }
    }

    public void editFloor(User user, int floorNumber, Map<VehicleType, Integer> newVehicleSpaceConfig) {
        if (user instanceof Admin admin) {
            for (ParkingFloor floor : floors) {
                if (floor.getFloorNumber() == floorNumber) {
                    floor.updateSpaces(newVehicleSpaceConfig);
                    System.out.println("✅ Floor " + floorNumber + " updated by Admin: " + admin.getName());
                    return;
                }
            }
            System.out.println("❌ Floor not found.");
        } else {
            System.out.println("❌ Only admins can edit floors.");
        }
    }
    // only admin can
    public void removeFloor(User user, int floorNumber) {
    if (user instanceof Admin admin) {
        Iterator<ParkingFloor> iterator = floors.iterator();
        while (iterator.hasNext()) {
            ParkingFloor floor = iterator.next();
            if (floor.getFloorNumber() == floorNumber) {
                iterator.remove();
                    System.out.println("✅ Floor " + floorNumber + " removed by Admin: " + admin.getName());
                    return;
                }
            }
            System.out.println("❌ Floor not found.");
        } else {
            System.out.println("❌ Only admins can remove floors.");
        }
    }
    
    
  
    public void parkVehicle(int floorNumber, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                boolean parked = floor.parkVehicle(vehicle);
                if (!parked) {
                    System.out.println("❌ No space on floor " + floorNumber + " for: " + vehicle.getType());
                }
                return;
            }
        }
        System.out.println("❌ Floor " + floorNumber + " not found.");
    }

    public void leaveSpot(int floorNumber, int spotNumber) {
        for (ParkingFloor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                floor.leaveSpot(spotNumber);
                return;
            }
        }
        System.out.println(" Floor not found.");
    }

    public void printAllFloorsAvailability() {
        for (ParkingFloor floor : floors) {
            floor.printAvailability();
        }
    }

    public void printAvailability(int floorNumber) {
        for (ParkingFloor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                floor.printAvailability();
                return;
            }
        }
        System.out.println("❌ Floor not found.");
    }

    private double calculateFee(VehicleType type, double hours) {

        switch (type) {
            case CAR -> {
                return 20 * hours;
            }
            case BIKE -> {
                return 10 * hours;
            }
            case TRUCK -> {
                return 30 * hours;
            }
            default -> {
                return 0;
            }
        }
    }

    public void returnVehicleAndPay(int floorNumber, int spotNumber) {
        for (ParkingFloor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                Vehicle vehicle = floor.leaveSpot(spotNumber);
                if (vehicle != null) {
                    Scanner scanner = new Scanner(System.in);
                System.out.print("Enter return time: ");
                long exitInput = scanner.nextInt();
                long durationMillis = exitInput - vehicle.getEntryTime(); // ✅ Correct


                    double hours = Math.ceil(durationMillis / (1000.0 * 60 * 60)); // round up
                    double fee = calculateFee(vehicle.getType(), hours);

    
                    System.out.println("Vehicle: " + vehicle.getLicensePlate());
                    System.out.println("⏱Duration: " + (int) hours + " hour(s)");
                    System.out.println("Fee: ₹" + fee);
                } else {
                    System.out.println("No vehicle found at that spot.");
                }
                return;
            }
        }
        System.out.println("Floor " + floorNumber + " not found.");
    }
    

    
}
