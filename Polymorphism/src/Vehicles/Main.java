package Vehicles;

import java.util.Scanner;

public class Main {
    public static Vehicle car;
    public static Vehicle truck;
    public static Vehicle bus;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] token = scanner.nextLine().split("\\s+");
        car = new Car(Double.parseDouble(token[1]), Double.parseDouble(token[2]), Double.parseDouble(token[3]));
        token = scanner.nextLine().split("\\s+");
        truck = new Truck(Double.parseDouble(token[1]), Double.parseDouble((token[2])), Double.parseDouble(token[3]));
        token = scanner.nextLine().split("\\s+");
        bus = new Bus(Double.parseDouble(token[1]), Double.parseDouble((token[2])), Double.parseDouble(token[3]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            token = scanner.nextLine().split("\\s+");
            try {
                switch (token[0]) {
                    case "Refuel":
                        refuelS(token);
                        break;
                    case "Drive":
                        System.out.println(driveIt(token));
                        break;
                    case "DriveEmpty":
                        System.out.println(bus.drive(Double.parseDouble(token[2]), "WINTER"));


                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());
        System.out.printf("Bus: %.2f%n", bus.getFuel());
    }

    private static String driveIt(String[] token) {
        switch (token[1]) {
            case "Car":
                return car.drive(Double.parseDouble(token[2]), "summer");
            case "Truck":
                return (truck.drive(Double.parseDouble(token[2]), "summer"));
            case "Bus":
                return bus.drive(Double.parseDouble(token[2]), "summer");
        }
        return null;
    }

    private static void refuelS(String[] token) {
        switch (token[1]) {
            case "Car":
                car.refuel(Double.parseDouble(token[2]));
                break;
            case "Truck":
                truck.refuel(Double.parseDouble(token[2]));
                break;
            case "Bus":
                bus.refuel(Double.parseDouble(token[2]));
                break;
        }
    }
}
