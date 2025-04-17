// Base class: MP
class MP {
    protected String name;
    protected String constituency;
    protected int spending;

    MP(String name, String constituency, int spending) {
        this.name = name;
        this.constituency = constituency;
        this.spending = spending;
    }

    public String getConstituency() {
        return constituency;
    }

    public String getDriver() {
        return "Default Car Driver";
    }

    public int getSpendingLimit() {
        return 100000; // ₹1 lakh
    }

    public boolean exceedsSpendingLimit() {
        return spending > getSpendingLimit();
    }

    public String getRole() {
        return "MP";
    }
}

// Minister class extends MP
class Minister extends MP {
    Minister(String name, String constituency, int spending) {
        super(name, constituency, spending);
    }

    @Override
    public int getSpendingLimit() {
        return 1000000; // ₹10 lakh
    }

    @Override
    public String getRole() {
        return "Minister";
    }
}

// PM class extends MP
class PM extends MP {
    PM(String name, String constituency, int spending) {
        super(name, constituency, spending);
    }

    @Override
    public int getSpendingLimit() {
        return 10000000; // ₹1 crore
    }

    @Override
    public String getDriver() {
        return "Aircraft Pilot + Car Driver";
    }

    @Override
    public String getRole() {
        return "PM";
    }

    public boolean allowArrest(Minister minister) {
        return true; // PM allows arrest of minister
    }
}

// Commissioner class
class Commissioner {
    PM pm;

    Commissioner(PM pm) {
        this.pm = pm;
    }

    public void canArrest(MP person) {
        if (!person.exceedsSpendingLimit()) {
            System.out.println(person.getRole() + " " + person.name + " has not exceeded the spending limit.");
            return;
        }

        if (person instanceof PM) {
            System.out.println("Cannot arrest PM: " + person.name);
        } else if (person instanceof Minister) {
            Minister minister = (Minister) person;
            if (pm.allowArrest(minister)) {
                System.out.println("Minister " + person.name + " arrested with PM's permission.");
            } else {
                System.out.println("PM did not allow arrest of Minister " + person.name);
            }
        } else {
            System.out.println("MP " + person.name + " arrested.");
        }
    }
}


public class IndianPoliticsDemo {
    public static void main(String[] args) {
        MP mp = new MP("Ravi", "Delhi", 200000); // Exceeds ₹1 lakh
        Minister minister = new Minister("Amit", "Mumbai", 1200000); // Exceeds ₹10 lakh
        PM pm = new PM("Narendra", "Varanasi", 15000000); // Exceeds ₹1 crore

        Commissioner commissioner = new Commissioner(pm);

        System.out.println("Drivers:");
        System.out.println(mp.getRole() + " Driver: " + mp.getDriver());
        System.out.println(minister.getRole() + " Driver: " + minister.getDriver());
        System.out.println(pm.getRole() + " Driver: " + pm.getDriver());

        System.out.println("\nArrest Checks:");
        commissioner.canArrest(mp);       
        commissioner.canArrest(minister); 
        commissioner.canArrest(pm);       
    }
}
