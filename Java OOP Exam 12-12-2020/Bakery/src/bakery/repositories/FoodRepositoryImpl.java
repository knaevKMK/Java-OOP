package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.OutputMessages.NONE_EXISTENT_FOOD;

public class FoodRepositoryImpl<T> implements FoodRepository<BakedFood> {
    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood food : models) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(BakedFood bakedFood) {
        //If a baked food with the given name already exists in the food repository,
        // throw an IllegalArgumentException with message "{type} {name} is already in the menu"
        for (BakedFood model : models) {
            if (model.getName().equals(bakedFood.getName())) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, this.getClass().getSimpleName(), bakedFood.getName()));
            }
        }
        this.models.add(bakedFood);
    }
}
