public class SubPassenger extends Passenger {

    // Constructors
    public SubPassenger(String ID, String name) {
        super(ID, name);
    }

    // Methods
    @Override
    public void reserveCar(Car car) throws Exception {
        if (car.getCapacity() > 0) {
            // Reserve the car
            setReservedCar(car);
            car.setCapacity(car.getCapacity() - 1);

            // Set the cost of the trip
            setTripCost(car.getRoute().getTripPrice() - (car.getRoute().getTripPrice() * 0.5));

            // type of the car:
            // if comfort don't add anything
            if (car.getType().equals("XL"))
                setTripCost(getTripCost() + 10);
            else if (car.getType().equals("Elite"))
                setTripCost(getTripCost() + 50);
        } else {
            throw new Exception("We are sorry "+ getName() + ", the car is full!");
        }
    }

    @Override
    public String displayInfo() {
        if (getReservedCar() != null)
            return super.displayInfo() + "\nReserved Car Code: " + getReservedCar().getCode() + "\nTrip Cost: " + getTripCost() + "\nRoute Price: " + getReservedCar().getRoute().getTripPrice();
        else
            return super.displayInfo();
    }
}
