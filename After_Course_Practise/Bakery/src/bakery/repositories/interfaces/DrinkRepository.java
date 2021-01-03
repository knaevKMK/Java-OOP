package bakery.repositories.interfaces;

import bakery.entities.interfaces.Drink;

public interface DrinkRepository<T> extends Repository<Drink> {
    T getByName(String name);
}
