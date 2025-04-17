
// ParkingRecords class
class ParkingRecords {
    Car car;
    Customer customer;
    float parkingTime;
    float parkingReturnTime;
    float totalPrice;
// Constructor for ParkingRecords class
    ParkingRecords(Car car, Customer customer, float parkingTime) {
        this.car = car;
        this.customer = customer;
        this.parkingTime = parkingTime;
        this.parkingReturnTime = -1; // -1 indicates car is still parked
    }

    public void markReturned(float returnTime) {
        this.parkingReturnTime = returnTime;
    }

    public float calculatePrice() {
        float duration = parkingReturnTime - parkingTime;
        if (duration <= 0)
            return 0;
        float price = 0;

        if (duration > 0) {
            price += 4;
            duration -= 1;
        }

        if (duration > 0) {
            float nextTwoHours = Math.min(2, duration);
            price += nextTwoHours * 3.5f;
            duration -= nextTwoHours;
        }

        if (duration > 0) {
            price += duration * 2.5f;
        }

        return price;
    }
}








