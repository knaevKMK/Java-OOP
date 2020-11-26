package WildFarm.Animal;

import WildFarm.Food.Food;

public class Mouse extends Mammal {
    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super( animalType,animalName, animalWeight, livingRegion);
    }

    public void eat(Food food) {
        if (food.getClass().getSimpleName().equalsIgnoreCase("vegetable")) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }


}
