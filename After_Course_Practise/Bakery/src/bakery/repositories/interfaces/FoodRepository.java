package bakery.repositories.interfaces;

import bakery.entities.interfaces.BakedFood;

public interface FoodRepository <T> extends Repository<BakedFood>{
    T getByName(String name);
}
