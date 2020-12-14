package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl<T> implements FoodRepository<BakedFood> {
    private Collection<BakedFood> list;

    public FoodRepositoryImpl() {
        this.list = new ArrayList<>();
    }


    @Override
    public BakedFood getByName(String name) {
        for (BakedFood food : list) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(this.list);
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.list.add(bakedFood);
    }
}
