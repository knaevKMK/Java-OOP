package WildFarm.Animal;

import WildFarm.Food.Food;

public class Zebra extends Mammal {

    public Zebra(String animalType,String animalName, Double animalWeight, String livingRegion) {
        super(animalType ,animalName, animalWeight, livingRegion);
    }
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equalsIgnoreCase("vegetable")) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }


}
