import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Passengers
        ArrayList<Passenger> passengers = new ArrayList<>();

        // Routes
        System.out.println("Initializing routes...");
        Route route = new Route("Riyadh", "Jeddah", 500);
        Route route2 = new Route("Jeddah", "Riyadh", 700);
        System.out.println("Routes initialized.");
        ArrayList<Route> routes = new ArrayList<>();
        routes.add(route);
        routes.add(route2);

        System.out.println();

        // Cars
        System.out.println("Initializing cars...");
        Car tahoe = new Car("RUH-12", route, 4, "Comfort"); // try: XL, Elite for type (extra fee)
        Car mustang = new Car("JED-03", route2, 0, "Elite");
        System.out.println("Cars initialized.");
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(tahoe);
        cars.add(mustang);

        System.out.println();

        // Passengers
        System.out.println("Initializing passengers...");
        Passenger mohammad = new SubPassenger("1", "mohammad");
        Passenger ahmad = new NonSubPassenger("2", "ahmad", false);
        System.out.println("Passengers initialized.");

        System.out.println();

        // Try to reserve cars
        // should work
        // NOTE: This is a fixed print message, if arguments change it will be invalid!
        System.out.println("Mohammad tries to register for a trip with " + tahoe.getCode() + " that has a capacity of: " + tahoe.getCapacity() + " from: " + route.getPickUpAddress() + " to: " + route.getDestinationAddress());
        try {
            mohammad.reserveCar(tahoe);
            // NOTE: This is a fixed print message, if arguments change it will be invalid!
            System.out.println("Registered Successfully, and now " + tahoe.getCode() + " has a capacity of: " + tahoe.getCapacity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(mohammad.displayInfo());


        System.out.println();

        // should throw
        // NOTE: This is a fixed print message, if arguments change it will be invalid!
        System.out.println("Ahmad tries to register for a trip with " + mustang.getCode() + " that has a capacity of: " + mustang.getCapacity() + " from: " + route2.getPickUpAddress() + " to: " + route2.getDestinationAddress());
        try {
            ahmad.reserveCar(mustang);
            // NOTE: This is a fixed print message, if arguments change it will be invalid!
            System.out.println("Registered Successfully, and now " + mustang.getCode() + " has a capacity of: " + mustang.getCapacity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ahmad.displayInfo());

        System.out.println();

        System.out.println("Printing ArrayList that contains all passengers");
        passengers.add(mohammad);
        passengers.add(ahmad);
        for (Passenger passenger : passengers) {
            System.out.println(passenger.displayInfo());
        }

        System.out.println();

        System.out.println("NOTE: Some messages (especially ones showing car capacity in main) are hard coded " +
                "\nbased on the project document, if you change some arguments they will be invalid.");

        System.out.println();

        // BONUS SECTION (User Interaction)
        Scanner sc = new Scanner(System.in);
        boolean running = false;

        // Check if user wants to try the app
        System.out.println("====== Bonus Section =====");
        System.out.println("Do you want to try the app yourself? (y/n)");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            running = true;
        } else if (choice.equalsIgnoreCase("n")) {
            running = false;
            System.out.println("Quitting Program...");
        } else {
            System.out.println("invalid input, quitting the program!");
        }

        // Loop menu until exit
        while (running) {
            System.out.println("what do you want to do:\n1. New Route\n2. New Car\n3. New Passenger\n4. View all Passengers\n5. View all Cars\n6. View all Routes\n7. Register a passenger in a car\n8. Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    sc.nextLine();

                    // Take user input for new Route object
                    String pickUpAddress = null;
                    String destinationAddress = null;
                    double tripPrice = 0.0;
                    try {
                        System.out.println("Enter the pick up address: ");
                        pickUpAddress = sc.nextLine();
                        System.out.println("Enter the destination address: ");
                        destinationAddress = sc.nextLine();
                        System.out.println("Enter the trip price");
                        tripPrice = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                    }

                    // instantiate new Route and add it to the routes ArrayList
                    try {
                        routes.add(new Route(pickUpAddress, destinationAddress, tripPrice));
                        printRoutes(routes);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    sc.nextLine();

                    // Take user input for new Car object
                    String carCode = null;
                    Route newRoute = null;
                    int carCapacity = 4; // default
                    String carType = "Comfort"; // default
                    try {
                        System.out.println("Enter the car code: ");
                        carCode = sc.nextLine();
                        System.out.println("Choose a route: ");
                        printRoutes(routes); // show user all routes to choose from
                        int routeIndex = sc.nextInt();
                        newRoute = routes.get(routeIndex - 1);
                        // car type to determine capacity and pricing (bonus)
                        System.out.println("Enter the car type:\n1. Comfort (4 seats)\n2. XL (6 seats)\n3. Elite (Luxury)");
                        int carTypeChoice = sc.nextInt();
                        if (carTypeChoice == 1) {
                            carType = "Comfort";
                            carCapacity = 4; // just for clarity
                        } else if (carTypeChoice == 2) {
                            carType = "XL";
                            carCapacity = 6;
                        } else if (carTypeChoice == 3) {
                            carType = "Elite";
                            carCapacity = 4; // just for clarity
                        } else {
                            System.out.println("invalid input!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                    }
                    try {
                        cars.add(new Car(carCode, newRoute, carCapacity, carType));
                        printCars(cars);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    sc.nextLine();
                    try {
                        System.out.println("Enter passenger ID: ");
                        String passengerID = sc.nextLine();
                        System.out.println("Enter passenger name: ");
                        String passengerName = sc.nextLine();
                        System.out.println("is your passenger subscribed? (y/n)");
                        String passengerSubscribed = sc.nextLine();
                        Passenger newPassenger = null;
                        if (passengerSubscribed.equalsIgnoreCase("y")) {
                            newPassenger = new SubPassenger(passengerID, passengerName);
                        } else if (passengerSubscribed.equalsIgnoreCase("n")) {
                            System.out.println("Do you have a discount coupon? (y/n)");
                            String discountCoupon = sc.nextLine();
                            if (discountCoupon.equalsIgnoreCase("y")) {
                                newPassenger = new NonSubPassenger(passengerID, passengerName, true);
                            } else if (discountCoupon.equalsIgnoreCase("n")) {
                                newPassenger = new NonSubPassenger(passengerID, passengerName, false);
                            } else {
                                System.out.println("invalid input!");
                            }
                        } else {
                            System.out.println("invalid input!");
                        }
                        if (newPassenger != null) {
                            passengers.add(newPassenger);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                    }
                    printPassengers(passengers);
                    break;
                case 4:
                    printPassengers(passengers);
                    break;
                case 5:
                    printCars(cars);
                    break;
                case 6:
                    printRoutes(routes);
                    break;
                case 7:
                    try {
                        System.out.println("Which passenger you want to register? ");
                        printPassengers(passengers);
                        int passengerChoice = sc.nextInt();
                        if (passengerChoice < 1 || passengerChoice > passengers.size()) {
                            System.out.println("invalid input!");
                        } else {
                            System.out.println("Which car you want to reserve?");
                            printCars(cars);
                            int carChoice = sc.nextInt();
                            if (carChoice < 1 || carChoice > cars.size()) {
                                System.out.println("invalid input!");
                            } else {
                                try {
                                    passengers.get(passengerChoice - 1).reserveCar(cars.get(carChoice - 1));
                                    System.out.println("Successfully reserved!");
                                    System.out.println(passengers.get(passengerChoice - 1).displayInfo());
                                    System.out.println(cars.get(carChoice - 1));
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("See you!");
                    break;
                default:
                    System.out.println("invalid input!");
            }
        }
    }

    public static void printRoutes(ArrayList<Route> routes) {
        int index = 1;
        for (Route route : routes) {
            System.out.print(index++ + " ");
            System.out.println(route);
        }
    }

    public static void printCars(ArrayList<Car> cars) {
        int index = 1;
        for (Car car : cars) {
            System.out.print(index++ + " ");
            System.out.println(car);
        }
    }

    public static void printPassengers(ArrayList<Passenger> passengers) {
        int index = 1;
        for (Passenger passenger : passengers) {
            System.out.print(index++ + " ");
            System.out.println(passenger.displayInfo());
        }
    }
}