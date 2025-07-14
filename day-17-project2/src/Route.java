public class Route {
    // Attributes
    private String pickUpAddress;
    private String destinationAddress;
    private double tripPrice;

    // Constructors
    public Route(String pickUpAddress, String destinationAddress, double tripPrice) {
        this.pickUpAddress = pickUpAddress;
        this.destinationAddress = destinationAddress;
        setTripPrice(tripPrice);
    }

    // Getters and Setters
    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(double tripPrice) {
        if (tripPrice < 0)
            throw new IllegalArgumentException("trip price can't be negative");
        else
            this.tripPrice = tripPrice;
    }

    @Override
    public String toString() {
        return "Route{" +
                "pickUpAddress='" + pickUpAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", tripPrice=" + tripPrice +
                '}';
    }
}
