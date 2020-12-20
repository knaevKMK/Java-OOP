package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;
    private boolean isAlive;

    protected BasePlayer(String name, int lifePoints) {
        setName(name);
        setLifePoints(lifePoints);
        this.gunRepository = new GunRepository<>();
        isAlive = true;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }

        //o	All names are unique
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {

        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        if (lifePoints == 0) {
            this.isAlive = false;
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
//The takeLifePoints method decreases players' life points.
        if (points > this.lifePoints) {
            points = this.lifePoints;
        }
//•	Player's life points should not drop below zero
        this.setLifePoints(this.getLifePoints() - points);
        if (getLifePoints() == 0) {
            this.isAlive = false;
        }
    }
}
