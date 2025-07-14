public abstract class Passenger {
    // Attributes
    private String ID;
    private String name;
    private Car reservedCar;
    private double tripCost;

    // Constructors
    public Passenger(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    // Methods
    public abstract void reserveCar(Car car) throws Exception;

    public String displayInfo() {
        return "====Passenger Information====" + "\nID: " + ID + "\nName: " + name;
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getReservedCar() {
        return reservedCar;
    }

    public void setReservedCar(Car reservedCar) {
        this.reservedCar = reservedCar;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        if (tripCost < 0)
            throw new IllegalArgumentException("Trip cost cannot be less than 0");
        else
            this.tripCost = tripCost;
    }
}
