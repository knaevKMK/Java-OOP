package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.OutputMessages.NON_EXISTENT_DRINK;

public class DrinkRepositoryImpl<T> implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink drink : models) {
            if (drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand)) {
                return drink;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Drink drink) {
        for (Drink model : models) {
            if (model.getName().equals(drink.getName())) {
                throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, this.getClass().getSimpleName(), drink.getName()));
            }
        }
        this.models.add(drink);

    }
}
