public class NonSubPassenger extends Passenger {
    // Attributes
    private boolean discountCoupon;

    // Constructors
    public NonSubPassenger(String ID, String name, boolean discountCoupon) {
        super(ID, name);
        this.discountCoupon = discountCoupon;
    }

    // Methods
    @Override
    public void reserveCar(Car car) throws Exception {
        if (car.getCapacity() > 0) {
            // Reserve the car
            setReservedCar(car);
            car.setCapacity(car.getCapacity() - 1);

            // Check for discount
            if (discountCoupon)
                setTripCost(car.getRoute().getTripPrice() - (car.getRoute().getTripPrice() * 0.1));
            else
                setTripCost(car.getRoute().getTripPrice());

        } else {
            throw new Exception("We are sorry "+ getName() + ", the car is full!");
        }
    }

    @Override
    public String displayInfo() {
        if (getReservedCar() != null)
            return super.displayInfo() + "\nReserved Car Code: " + getReservedCar().getCode() + "\nTrip Cost: " + getTripCost();
        else
            return super.displayInfo();
    }

    // Getters and Setters
    public boolean isDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(boolean discountCoupon) {
        this.discountCoupon = discountCoupon;
    }
}
