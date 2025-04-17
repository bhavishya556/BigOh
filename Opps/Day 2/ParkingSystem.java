import java.util.ArrayList;
import java.util.Scanner;

class ParkingSystem {
    private ArrayList<ParKingFlore> floors = new ArrayList<>();
    private ArrayList<ParkingRecords> records = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void addFlore(ParKingFlore pf) {
        floors.add(pf);

    }

    public void showAllFloors() {
        for (ParKingFlore pf : floors) {
            pf.showParkingFlore();
        }
    }
// Method to show all floors in the parking system
    public void addFloorInteractive() {

        System.out.println("You are going to add floor number " + (floors.size() + 1));

        int floorNumber = floors.size() + 1;
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        System.out.print("Enter number of Entries: ");
        int entry = sc.nextInt();
        System.out.print("Enter number of Exits: ");
        int exit = sc.nextInt();

        ParKingFlore newFloor = new ParKingFlore(rows, cols, floorNumber, entry, exit);
        floors.add(newFloor);
        System.out.println("Floor " + floorNumber + " added.");
    }
// Method to remove a floor from the parking system
    public void removeFloorInteractive() {
        System.out.print("Enter floor number to remove: ");
        int floorNumber = sc.nextInt();
        removeFloor(floorNumber);
    }
//
    public void updateFloorInteractive() {
        System.out.print("Enter floor number to update: ");
        int floorNumber = sc.nextInt();
        System.out.print("Enter new rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter new columns: ");
        int cols = sc.nextInt();
        System.out.print("Enter new number of entries: ");
        int entries = sc.nextInt();
        System.out.print("Enter new number of exits: ");
        int exits = sc.nextInt();
        
        System.out.print("Enter new reserved slots for bikes: ");
        int bikeSlots = sc.nextInt();
        System.out.print("Enter new reserved slots for trucks: ");
        int truckSlots = sc.nextInt();
    
        int totalSlots = rows * cols;
        if (bikeSlots + truckSlots > totalSlots) {
            System.out.println("Reserved slots exceed total available slots. Update failed.");
            return;
        }
    
        ParKingFlore updatedFloor = new ParKingFlore(rows, cols, floorNumber, entries, exits);
        updatedFloor.updateReservedSlots(bikeSlots, truckSlots);  // apply custom slots after construction
        updateFloor(floorNumber, updatedFloor);
    
        System.out.println("✅ Floor " + floorNumber + " updated successfully.");
    }

    
    
// Method to park a car in the parking system
    public void parkCarInteractive() {
        System.out.println("we have " + floors.size() + " floore choose any of them");
        System.out.print("Enter floor number: ");
        int floorNumber = sc.nextInt();
        if (floorNumber < 0 || floorNumber > floors.size()) {
            System.out.println("invalid floor number try again");
            parkCarInteractive();
        }
        ParKingFlore flore = floors.get(floorNumber - 1);
        if (flore.isSpaceAvaliable) {

            flore.showParkingFlore();
        } else {
            flore.showParkingFlore();
            System.out.println(" choose another floore");
            parkCarInteractive();

        }

        sc.nextLine();
        System.out.print("Enter vehicle type (car/bike/truck): ");
        String type = sc.nextLine().toLowerCase();
        System.out.print("Enter " + type + "name: ");
        String carName = sc.nextLine();
        System.out.print("Enter " + type + "number: ");
        String carNumber = sc.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter row: ");
        int row = sc.nextInt();
        System.out.print("Enter column: ");
        int col = sc.nextInt();
        System.out.print("Enter parking time in hours (e.g., 1.5): ");
        float parkingTime = sc.nextFloat();

        Car car = new Car(carName, carNumber, type);
        Customer customer = new Customer(customerName, car);
        parkCar(floorNumber, car, customer, row, col, parkingTime);
    }
// Method to return a car in the parking system
    public void returnCarInteractive() {
        sc.nextLine();
        System.out.print("Enter car number: ");
        String carNumber = sc.nextLine();
        System.out.print("Enter return time in hours (e.g., 3.5): ");
        float returnTime = sc.nextFloat();
        returnCar(carNumber, returnTime);
    }
// Method to park a car in the parking system
    public void parkCar(int floorNumber, Car car, Customer customer, int row, int col, float parkingTime) {
        for (ParKingFlore floor : floors) {
            if (floor.floreNumber == floorNumber) {
                if(floor.doCarParking(car, row, col,customer,parkingTime)){
                    ParkingRecords record = new ParkingRecords(car, customer, parkingTime);
                    records.add(record);
                    System.out.println(car.carType + " parked successfully on floor " );
                }
          
                return;
            }
        }
        System.out.println("Floor not found.");
    }
// Method to return a car in the parking system
    public void returnCar(String carNumber, float returnTime) {
        for (ParkingRecords record : records) {
            if (record.car.carNumber.equals(carNumber) && record.parkingReturnTime == -1) {
                record.markReturned(returnTime);
                float price = record.calculatePrice();
                record.totalPrice = price;

                for (ParKingFlore floor : floors) {
                    if (floor.hasCar(carNumber)) {
                        floor.removeCar(carNumber);
                        System.out.println("✅ Car returned. Total price: $" + price);
                        return;
                    }
                }
            }
        }
        System.out.println("Car not found or already returned.");
    }
// Method to remove a floor from the parking system
    public void removeFloor(int floorNumber) {
        for (int i = 0; i < floors.size(); i++) {
            if (floors.get(i).floreNumber == floorNumber) {
                floors.remove(i);
                System.out.println("Floor " + floorNumber + " removed.");
                return;
            }
        }
        System.out.println("Floor not found.");
    }
// Method to update a floor in the parking system
    public void updateFloor(int floorNumber, ParKingFlore updatedFloor) {
        for (int i = 0; i < floors.size(); i++) {
            if (floors.get(i).floreNumber == floorNumber) {
                floors.set(i, updatedFloor);
                System.out.println("Floor " + floorNumber + " updated.");
                return;
            }
        }
        System.out.println("Floor not found.");
    }
// Method to show all parking records in the parking system
    public void showAllRecords() {
        if (records.isEmpty()) {
            System.out.println("No parking records yet.");
            return;
        }

        for (ParkingRecords rec : records) {
            System.out.println(rec.car.carType + rec.car.name + " (" + rec.car.carNumber + ")");
            System.out.println("Customer: " + rec.customer.name);
            System.out.println("Start: " + rec.parkingTime + "h");
            if (rec.parkingReturnTime != -1) {
                System.out.println(" Return: " + rec.parkingReturnTime + "h");
                System.out.println("Price: $" + rec.totalPrice);
            } else {
                System.out.println("Still Parked");
            }
        }
    }
// Method to add a parking record to the parking system
    public void addRecords (ParkingRecords rec){
        records.add(rec);

    }
}
