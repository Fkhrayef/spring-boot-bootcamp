import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vehicle Rental System");
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> rentedVehicles = new ArrayList<>();

        int choice;
        boolean running = true;

        while(running){
            System.out.println("Please select an option:");
            System.out.println("1. Rent a Car");
            System.out.println("2. Rent a Bike");
            System.out.println("3. Rent a Truck");
            System.out.println("4. View Rented Vehicles");
            System.out.println("5. Exit");

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    sc.nextLine();
                    // input
                    String model;
                    int days;
                    try {
                        System.out.print("Enter Car Model: ");
                        model = sc.nextLine();
                        System.out.print("Enter Rental Days: ");
                        days = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid input.");
                        sc.nextLine();
                        continue;
                    }

                    // obj instantiation and add to list
                    try {
                        Vehicle car = new Car(model, days);
                        rentedVehicles.add(car);
                        car.displayDetails();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case 2:
                    sc.nextLine();

                    // input
                    String brand;
                    int hours;
                    try {
                        System.out.print("Enter Bike Brand: ");
                        brand = sc.nextLine();
                        System.out.print("Enter Rental Hours: ");
                        hours = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid input.");
                        sc.nextLine();
                        continue;
                    }

                    // obj instantiation and add to list
                    try {
                        Vehicle bike = new Bike(brand, hours);
                        rentedVehicles.add(bike);
                        bike.displayDetails();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case 3:
                    sc.nextLine();

                    // input
                    String type;
                    int weeks;
                    try {
                        System.out.print("Enter Truck Type: ");
                        type = sc.nextLine();
                        System.out.print("Enter Rental Weeks: ");
                        weeks = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid input.");
                        sc.nextLine();
                        continue;
                    }

                    // obj instantiation and add to list
                    try {
                        Vehicle truck = new Truck(type, weeks);
                        rentedVehicles.add(truck);
                        truck.displayDetails();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case 4:
                    if (rentedVehicles.isEmpty()) {
                        System.out.println("No vehicles rented yet.");
                    } else {
                        System.out.println("Rented Vehicles:");
                        for (Vehicle vehicle : rentedVehicles) {
                            vehicle.displayDetails();
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the Vehicle Rental System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}