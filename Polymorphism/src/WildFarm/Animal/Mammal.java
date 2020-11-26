package WildFarm.Animal;

import WildFarm.Animal.Animal;
import WildFarm.DecimalFormat;
import WildFarm.Food.Food;

public abstract class Mammal extends Animal {

    public String getLivingRegion() {
        return livingRegion;
    }

    protected String livingRegion;

    protected Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }



    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName()
                , DecimalFormat.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
