package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class GunRepository<T> implements Repository<Gun> {
    private Collection<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getGuns() {
        return guns;
    }

    @Override
    public void add(Gun model) {
        this.guns.add(model);
//        if (!this.guns.contains(model)) {
//            this.guns.add(model);
//        }
//Adds a gun in the collection.
//•	If the gun already exists in the player's collection of guns, don't add it. Every gun is unique.
    }

    @Override
    public boolean remove(Gun model) {
        return this.guns.remove(model);
    }

    @Override
    public Gun find(String name) {
        for (Gun model : guns) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
