package WildFarm.Animal;

import WildFarm.Food.Food;

public class Tiger extends Felime {
    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equalsIgnoreCase("meat")) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
