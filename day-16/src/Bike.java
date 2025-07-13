public class Bike implements Vehicle{
    private String brand;
    private int hour;

    public Bike(String brand, int hour) {
        this.brand = brand;
        setHour(hour);
    }

    @Override
    public double calculateRentalCost() {
        return getHour() * 10;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike - Rental Details:");
        System.out.println("Brand: " + getBrand());
        System.out.println("Hourly Rental Rate: $10");
        System.out.printf("Rental Cost: $%.2f", calculateRentalCost());
        System.out.println();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 1)
            throw new IllegalArgumentException("Number of hours must be greater than 0.");
        else
            this.hour = hour;
    }
}
