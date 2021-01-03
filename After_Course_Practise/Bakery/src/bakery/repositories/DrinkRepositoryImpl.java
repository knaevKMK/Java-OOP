package bakery.repositories;

import bakery.entities.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.Collection;

public class DrinkRepositoryImpl implements DrinkRepository <Drink> {

    @Override
    public Drink getByName(String name) {
        return null;
    }

    @Override
    public void add(Drink model) {

    }

    @Override
    public Collection<Drink> getAll() {
        return null;
    }
}
