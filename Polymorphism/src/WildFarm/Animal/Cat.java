package WildFarm.Animal;

import WildFarm.DecimalFormat;
import WildFarm.Food.Food;

public class Cat extends Felime {
    private String catBrred;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String catBrred) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.catBrred = catBrred;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName()
                , this.catBrred
                , DecimalFormat.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
