public class Car {
    // Attributes
    private String code;
    private Route route;
    private int capacity;
    private String type; // Comfort (Standard 4 seats) - XL (6 Seats) - Elite (Luxury)

    // Constructors
    public Car(String code, Route route, int capacity, String type) {
        this.code = code;
        this.route = route;
        setCapacity(capacity);
        setType(type);
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Capacity less than 0");
        else
            this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("Comfort") || type.equalsIgnoreCase("XL") || type.equalsIgnoreCase("Elite")) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "code='" + code + '\'' +
                ", route=" + route +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}
