
class ParKingFlore {
    int lenght;
    int width;
    int floreNumber;
    int numberOfEntry;
    int numberOfExit;
    boolean isSpaceAvaliable;
    int reserverSlotForBike;
    int reserverSlotForTruck;
    Car[][] parkingGrid;

    //constructor
    ParKingFlore(int lenght, int width, int floreNumber, int numberOfEntry, int numberOfExit) {
        this.lenght = lenght;
        this.width = width;
        this.floreNumber = floreNumber;
        this.numberOfEntry = numberOfEntry;
        this.numberOfExit = numberOfExit;
        this.reserverSlotForBike = 5;
        this.reserverSlotForTruck = 5;
        parkingGrid = new Car[lenght][width];
        this.isSpaceAvaliable = true;

        int totalSlot = lenght * width;
        int reservedSlot = reserverSlotForBike + reserverSlotForTruck;

        int carSlot = totalSlot - reservedSlot;
        int bikeSlot = reserverSlotForBike;
        int truckSlot = reserverSlotForTruck;

// Initialize parking grid with vehicles
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < width; j++) {
                if (carSlot > 0) {
                    parkingGrid[i][j] = new Car("car", "-1", "car");
                    carSlot--;

                } else if (bikeSlot > 0) {

                    parkingGrid[i][j] = new Car("bike", "-1", "bike");
                    bikeSlot--;
                } else if (truckSlot > 0) {
                    parkingGrid[i][j] = new Car("truck", "-1", "truck");
                    truckSlot--;

                }

            }
        }
    }
    // getter and setter methods
    public int getLen() {
        return lenght;
    }

    public int getWidth() {
        return width;
    }

   // Method to update reserved slots for bikes and trucks
    public void updateReservedSlots(int newBikeSlots, int newTruckSlots) {
        int totalSlots = lenght * width;
        int reservedSlots = newBikeSlots + newTruckSlots;
    
        if (reservedSlots > totalSlots) {
            System.out.println("Error: Reserved slots exceed total available slots.");
            return;
        }
    
        this.reserverSlotForBike = newBikeSlots;
        this.reserverSlotForTruck = newTruckSlots;
    
        int carSlots = totalSlots - reservedSlots;
        int bikeSlots = newBikeSlots;
        int truckSlots = newTruckSlots;

    // Reinitialize the parking grid with updated reserved slots
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < width; j++) {
                if (carSlots > 0) {
                    parkingGrid[i][j] = new Car("car", "-1", "car");
                    carSlots--;
                } else if (bikeSlots > 0) {
                    parkingGrid[i][j] = new Car("bike", "-1", "bike");
                    bikeSlots--;
                } else if (truckSlots > 0) {
                    parkingGrid[i][j] = new Car("truck", "-1", "truck");
                    truckSlots--;
                }
            }
        }
    
        System.out.println("Reserved slots updated successfully!");
    }
    // Method to show parking floor details
    public void showParkingFlore() {
        System.out.println("Parking Floor Numbe = " + floreNumber);
        System.out.println();

        int numberOfCarParked = 0;
        int totalSpace = 0;
        int emptySpace = 0;
// Display the parking grid
        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                System.out.print(" | " + parkingGrid[i][j].name + " | ");
                if (parkingGrid[i][j].carNumber == "-1") {
                    emptySpace++;

                }
            }
            System.out.println("\n");
        }

        totalSpace = (getLen()) * (getWidth());
        numberOfCarParked = totalSpace - emptySpace;

        System.out.println("Floor Details : ");

        System.out.println("Car Parked = " + numberOfCarParked + " space avaliabel for car = " + emptySpace
                + " Total space in floor for car = " + totalSpace);
        if (totalSpace == numberOfCarParked) {
            System.out.println("floore is full choose another floor");

        }
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------");

    }
    // Method to check if space is available for parking
    public boolean isSpaceAvaliable() {

        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (parkingGrid[i][j].carNumber != "-1") {
                    return true;
                }
            }

        }
        isSpaceAvaliable = false;
        return false;
    }
// Method to check if space is available for car
    public boolean isSpaceAvaliableCar() {

        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (parkingGrid[i][j].carType != "car" && parkingGrid[i][j].carNumber != "-1") {
                    return true;
                }
            }

        }
        isSpaceAvaliable = false;
        return false;
    }
// Method to check if space is available for bikes
    public boolean isSpaceAvaliableBike() {

        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (parkingGrid[i][j].carType != "bike" && parkingGrid[i][j].carNumber != "-1") {
                    return true;
                }
            }

        }
        isSpaceAvaliable = false;
        return false;
    }
// Method to check if space is available for trucks
    public boolean isSpaceAvaliableTruck() {

        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (parkingGrid[i][j].carType != "truck" && parkingGrid[i][j].carNumber != "-1") {
                    return true;
                }
            }

        }
        isSpaceAvaliable = false;
        return false;
    }
    // Method to park a car in the parking grid
    public boolean doCarParking(Car car, int row, int col, Customer customer, float parkingTime) {
        Car currentSlot = parkingGrid[row][col];
        if (row < 0 || row >= lenght || col < 0 || col >= width) {
            System.out.println("Invalid parking spot.");
            return false;
        }
    
    
        else if(!currentSlot.carNumber.equals("-1")) {
            System.out.println("Another vehicle is already parked here.");
            return false;
        }
    
        else if (!currentSlot.carType.equals(car.carType)) {
            System.out.println("Your vehicle type doesn't match this slot.");
            return false;
        }
        else{

            
            parkingGrid[row][col] = car;
            System.out.println("Vehicle parked successfully at (" + row + ", " + col + ").");

         
            return true;
        }
    }
    // Method to remove a car from the parking grid

    public void removeCar(String carNumber) {
        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                Car vehicel = parkingGrid[i][j];
                if (parkingGrid[i][j].carNumber.equals(carNumber)) {
                    parkingGrid[i][j] = new Car(vehicel.name, "-1", vehicel.carType);
                    return;
                }
            }
        }
    }
// Method to check if a car is present in the parking grid
    public boolean hasCar(String carNumber) {
        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (parkingGrid[i][j].carNumber.equals(carNumber)) {
                    return true;
                }
            }
        }
        return false;
    }
}

