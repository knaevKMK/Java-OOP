package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(guns);
    }

    @Override
    public void add(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
//•	If the gun is null, throw a NullPointerException with message: "Cannot add null in Gun Repository".
//•	Adds a gun in the collection.

        this.guns.add(gun);
    }

    @Override
    public boolean remove(Gun model) {
        //•	Removes a gun from the collection. Returns true if the removal was successful, otherwise - false.
        return this.getModels()
                .remove(model);
        //.removeIf(gun -> gun.equals(model));
    }

    @Override
    public Gun findByName(String name) {
//        //•	Returns the first gun with the given name, if there is such gun. Otherwise, returns null.
        Gun gun = getModels().stream().filter(gun1 -> gun1.getName().equals(name)).findFirst().orElse(null);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        return gun;
    }

    public void isInvalid(String type) {
        throw new IllegalArgumentException(INVALID_GUN_TYPE);
    }
}
