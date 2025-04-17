package ParkingLot;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<>(); // List to store created users

    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot();
        User currentUser = null;

        System.out.println("🚗 Welcome to Parking Lot Management System");

        // Admin or User login
        while (currentUser == null) {
            System.out.println("Login as:\n1. Admin\n2. User");
            System.out.print("Choose option: ");
            int loginChoice = scanner.nextInt();
            scanner.nextLine();

            switch (loginChoice) {
                case 1 -> {
                    System.out.print("Enter Admin Name: ");
                    String adminName = scanner.nextLine();
                    currentUser = new Admin(adminName);
                }
                case 2 -> {
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();
                    currentUser = new User(userName);
                }
                default -> System.out.println("❌ Invalid login option. Try again.");
            }
        }

        // Main menu loop
        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Add Floor");
            System.out.println("2. Edit Floor");
            System.out.println("3. Remove Floor");
            System.out.println("4. View All Floors Availability");
            System.out.println("5. View Specific Floor Availability");
            System.out.println("6. Park Vehicle");
            System.out.println("7. Return Vehicle & Pay");
            System.out.println("8. Add User (Only Admin)");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    if (currentUser instanceof Admin) addFloor(parkingLot, currentUser);
                    else System.out.println("Only Admin can add floors.");
                }
                case 2 -> {
                    if (currentUser instanceof Admin) editFloor(parkingLot, currentUser);
                    else System.out.println("Only Admin can edit floors.");
                }
                case 3 -> {
                    if (currentUser instanceof Admin) removeFloor(parkingLot, currentUser);
                    else System.out.println("Only Admin can remove floors.");
                }
                case 4 -> parkingLot.printAllFloorsAvailability();
                case 5 -> {
                    System.out.print("Enter Floor Number: ");
                    int floorNo = scanner.nextInt();
                    parkingLot.printAvailability(floorNo);
                }
                case 6 -> parkVehicle(parkingLot);
                case 7 -> returnVehicle(parkingLot);
                case 8 -> {
                    if (currentUser instanceof Admin) addUser();
                    else System.out.println("Only Admin can add users.");
                }
                case 9 -> {
                    System.out.println(" Exiting... Thank you!");
                    return;
                }
                default -> System.out.println(" Invalid option. Try again.");
            }
        }
    }

    // Method to add a floor
    private static void addFloor(ParkingLot parkingLot, User admin) {
        System.out.print("Enter Floor Number: ");
        int floorNo = scanner.nextInt();

        Map<VehicleType, Integer> config = new HashMap<>();
        for (VehicleType type : VehicleType.values()) {
            System.out.print("Enter number of spots for " + type + ": ");
            config.put(type, scanner.nextInt());
        }

        parkingLot.addFloor(admin, floorNo, config);
    }

    // Method to edit a floor
    private static void editFloor(ParkingLot parkingLot, User admin) {
        System.out.print("Enter Floor Number to Edit: ");
        int floorNo = scanner.nextInt();

        Map<VehicleType, Integer> config = new HashMap<>();
        for (VehicleType type : VehicleType.values()) {
            System.out.print("Enter new number of spots for " + type + ": ");
            config.put(type, scanner.nextInt());
        }

        parkingLot.editFloor(admin, floorNo, config);
    }

    // Method to remove a floor
    private static void removeFloor(ParkingLot parkingLot, User admin) {
        System.out.print("Enter Floor Number to Remove: ");
        int floorNo = scanner.nextInt();
        parkingLot.removeFloor(admin, floorNo);
    }

    // Method to park a vehicle
    private static void parkVehicle(ParkingLot parkingLot) {
        System.out.print("Enter Floor Number to Park In: ");
        int floorNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Vehicle Type (CAR/BIKE/TRUCK): ");
        String typeInput = scanner.nextLine().toUpperCase();

        VehicleType type = VehicleType.valueOf(typeInput);
        System.out.print("Enter Vehicle Number: ");
        String regNo = scanner.nextLine();

        Vehicle vehicle;
        switch (type) {
            case CAR -> vehicle = new Car(regNo, floorNo);
            case BIKE -> vehicle = new Bike(regNo, floorNo);
            case TRUCK -> vehicle = new Truck(regNo, floorNo);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        parkingLot.parkVehicle(floorNo, vehicle);
    }

    // Method to return a vehicle
    private static void returnVehicle(ParkingLot parkingLot) throws InterruptedException {
        System.out.print("Enter Floor Number: ");
        int floorNo = scanner.nextInt();
        System.out.print("Enter Spot Number: ");
        int spotNo = scanner.nextInt();

        Thread.sleep(2000); // simulate time passing
        parkingLot.returnVehicleAndPay(floorNo, spotNo);
    }

    // Method to add a new user (only accessible to Admin)
    private static void addUser() {
        System.out.println("Add a new User or Admin:");
        System.out.println("1. Add Admin");
        System.out.println("2. Add User");
        System.out.print("Choose option: ");
        int userChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        switch (userChoice) {
            case 1 -> {
                Admin newAdmin = new Admin(name);
                users.add(newAdmin);
                System.out.println("✅ Admin created successfully.");
            }
            case 2 -> {
                User newUser = new User(name);
                users.add(newUser);
                System.out.println("✅ User created successfully.");
            }
            default -> System.out.println("❌ Invalid option.");
        }
    }
}
