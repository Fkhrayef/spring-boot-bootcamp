public class Car implements Vehicle {
    private String model;
    private int days;

    public Car(String model, int days) {
        this.model = model;
        setDays(days);
    }

    @Override
    public double calculateRentalCost() {
        return getDays() * 50;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car - Rental Details:");
        System.out.println("Model: " + getModel());
        System.out.println("Daily Rental Rate: $50.00");
        System.out.printf("Rental Cost: $%.2f", calculateRentalCost());
        System.out.println();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        if (days < 1)
            throw new IllegalArgumentException("Number of days must be greater than 0.");
        else
            this.days = days;
    }
}
