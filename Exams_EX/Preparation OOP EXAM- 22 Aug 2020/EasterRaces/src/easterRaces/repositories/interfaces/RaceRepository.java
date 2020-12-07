package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.RACE_EXISTS;
import static easterRaces.common.ExceptionMessages.RACE_NOT_FOUND;

public class RaceRepository<E> implements Repository<Race> {
    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        Race race = this.races.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, name));
        }
        return race;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(races);
    }

    @Override
    public void add(Race race) {
        if (isExist(race)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, race.getName()));
        }
        this.races.add(race);
    }

    private boolean isExist(Race race) {
        for (Race race1 : races) {
            if (race.getName().equals(race1.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Race race) {
        return this.races.remove(race);
    }


}
