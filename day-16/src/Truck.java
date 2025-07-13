public class Truck implements Vehicle {
    private String type;
    private int week;

    public Truck(String type, int week) {
        this.type = type;
        setWeek(week);
    }

    @Override
    public double calculateRentalCost() {
        return getWeek() * 500;
    }

    @Override
    public void displayDetails() {
        System.out.println("Truck - Rental Details:");
        System.out.println("Type: " + getType());
        System.out.println("Weekly Rental Rate: $500");
        System.out.printf("Rental Cost: $%.2f", calculateRentalCost());
        System.out.println();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        if (week < 1)
            throw new IllegalArgumentException("Number of weeks must be greater than 0.");
        else
            this.week = week;
    }
}
