package bakery.repositories;

import bakery.entities.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.Collection;

public class FoodRepositoryImpl  implements FoodRepository<BakedFood> {
    @Override
    public BakedFood getByName(String name) {
        return null;
    }

    @Override
    public void add(BakedFood model) {

    }

    @Override
    public Collection<BakedFood> getAll() {
        return null;
    }
}
