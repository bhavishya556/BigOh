
import java.util.Scanner;

class Admin {

    ParkingSystem ps = new ParkingSystem();
    Scanner sc = new Scanner(System.in);
// Constructor for ParkingSystem
    Admin() {
        System.out.println("Welcome to the Parking Management System ");

        for (int i = 1; i <= 3; i++) {
            ParKingFlore pf = new ParKingFlore(5, 5, i, 1, 1);
            // admin.floors.add(pf);
            ps.addFlore(pf);
        }

        ps.showAllFloors();
        start();
    }
// Method to start the parking system
    public void start() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Floor");
            System.out.println("2. Remove Floor");
            System.out.println("3. Update Floor");
            System.out.println("4. Show All Floors");
            System.out.println("5. Park a Car");
            System.out.println("6. Return a Car");
            System.out.println("7. Show All Parking Records");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> ps.addFloorInteractive();
                case 2 -> ps.removeFloorInteractive();
                case 3 -> ps.updateFloorInteractive();
                case 4 -> ps.showAllFloors();
                case 5 -> ps.parkCarInteractive();
                case 6 -> ps.returnCarInteractive();
                case 7 -> ps.showAllRecords();
                case 8 -> {
                    System.out.println(" Exiting Parking System. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

}




