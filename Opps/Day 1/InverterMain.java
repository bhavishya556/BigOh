// Abstraction and Encapsulation
abstract class Inverter {
    private double current;
    private double voltage;

    // Constructor
    public Inverter(double current, double voltage) {
        this.current = current;
        this.voltage = voltage;
    }

    // Abstract method to be implemented by subclasses for specific behavior
    public abstract void inverterDetails();

    // Power rating calculation (Polymorphism)
    public double getPowerRating() {
        return current * voltage;
    }

    // Getter methods
    public double getCurrent() {
        return current;
    }

    public double getVoltage() {
        return voltage;
    }
}

// Inheritance and Polymorphism
class SolarInverter extends Inverter {
    private boolean hasBattery;
    private boolean isGridOn;
    private boolean hasSolarPanels;

    // Constructor
    public SolarInverter(double current, double voltage, boolean hasBattery, boolean isGridOn, boolean hasSolarPanels) {
        super(current, voltage);
        this.hasBattery = hasBattery;
        this.isGridOn = isGridOn;
        this.hasSolarPanels = hasSolarPanels;
    }

    @Override
    public void inverterDetails() {
        System.out.println("Solar Inverter Details:");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Has Battery: " + hasBattery);
        System.out.println("Supports GRID On: " + isGridOn);
        System.out.println("Has Solar Panels: " + hasSolarPanels);
    }

    
    public boolean hasBattery() {
        return hasBattery;
    }

    public boolean isGridOn() {
        return isGridOn;
    }

    public boolean hasSolarPanels() {
        return hasSolarPanels;
    }
}


class NonSolarInverter extends Inverter {
    private boolean hasBattery;

    
    public NonSolarInverter(double current, double voltage, boolean hasBattery) {
        super(current, voltage);
        this.hasBattery = hasBattery;
    }

    @Override
    public void inverterDetails() {
        System.out.println("Non-Solar Inverter Details:");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Has Battery: " + hasBattery);
    }

    
    public boolean hasBattery() {
        return hasBattery;
    }
}


class GTI extends SolarInverter {

    // Constructor
    public GTI(double current, double voltage) {
        super(current, voltage, false, true, true);  // GTI has no battery, supports GRID On and has solar panels
    }

    @Override
    public void inverterDetails() {
        System.out.println("GTI Inverter Details:");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Has Battery: " + hasBattery());
        System.out.println("Supports GRID On: " + isGridOn());
        System.out.println("Has Solar Panels: " + hasSolarPanels());
    }
}


class PCU extends SolarInverter {

    // Constructor
    public PCU(double current, double voltage) {
        super(current, voltage, true, false, true); 
    }

    @Override
    public void inverterDetails() {
        System.out.println("PCU Inverter Details:");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Has Battery: " + hasBattery());
        System.out.println("Supports GRID On: " + isGridOn());
        System.out.println("Has Solar Panels: " + hasSolarPanels());
    }
}


class Zelio extends NonSolarInverter {

    // Constructor
    public Zelio(double current, double voltage) {
        super(current, voltage, true); 
    }

    @Override
    public void inverterDetails() {
        System.out.println("Zelio Inverter Details:");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Has Battery: " + hasBattery());
    }
}

// Inheritance and Polymorphism
class iCruze extends NonSolarInverter {

    // Constructor
    public iCruze(double current, double voltage) {
        super(current, voltage, true); // iCruze has a battery
    }

    @Override
    public void inverterDetails() {
        System.out.println("iCruze Inverter Details:");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Has Battery: " + hasBattery());
    }
}

public class InverterMain {
    public static void main(String[] args) {
        

        Inverter gti = new GTI(10, 220);
        Inverter pcu = new PCU(8, 220);
        Inverter zelio = new Zelio(5, 220);
        Inverter icruze = new iCruze(7, 220);

        
        gti.inverterDetails();
        System.out.println();

        pcu.inverterDetails();
        System.out.println();

        zelio.inverterDetails();
        System.out.println();

        icruze.inverterDetails();
    }
}
