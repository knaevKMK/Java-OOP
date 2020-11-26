package WildFarm;

import WildFarm.Animal.*;
import WildFarm.Food.Food;
import WildFarm.Food.Meat;
import WildFarm.Food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Mammal> list = new ArrayList<>();
        String read;
        while (!"END".equalsIgnoreCase(read = scanner.nextLine())) {
            Mammal animal = getAnimal(read);
            list.add(animal);
            Food food = getFood();
            animal.makeSound();
            animal.eat(food);
        }
        for (Mammal animal : list) {
            System.out.println(animal);
        }

    }

    private static Food getFood() {
        String[] token = scanner.nextLine().split("\\s+");
        switch (token[0]) {
            case "Vegetable":
                return new Vegetable(Integer.parseInt(token[1]));

            case "Meat":
                return new Meat(Integer.parseInt(token[1]));
            default:
                return null;
        }
    }

    private static Mammal getAnimal(String read) {
        String[] token = read.split("\\s+");

        String animalType = token[0];
        String animalName = token[1];
        Double animalWeight = Double.parseDouble(token[2]);
        Integer foodEaten;
        String livingRegion = token[3];
        switch (animalType) {
            case "Cat":
                return new Cat(animalType, animalName, animalWeight, livingRegion, token[4]);

            case "Tiger":
                return new Tiger(animalType, animalName, animalWeight, livingRegion);

            case "Mouse":
                return new Mouse(animalType, animalName, animalWeight, livingRegion);

            case "Zebra":
                return new Zebra(animalType, animalName, animalWeight, livingRegion);

        }
        return null;
    }
}

