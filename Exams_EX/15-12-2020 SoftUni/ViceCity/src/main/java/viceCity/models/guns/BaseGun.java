package viceCity.models.guns;

import java.util.Objects;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;
    int firePerFire;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets, int firePer) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        setCanFire(true);
        this.firePerFire = firePer;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }
        //o	If the gun name is null or empty, throw a NullPointerException with message
        //"Name cannot be null or whitespace!"
        //o	All names are unique

        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        //•	bulletsPerBarrel – int
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        //o	If the bullets are below zero, throw an IllegalArgumentException with message
        //"Bullets cannot be below zero!"
        //o	The initial BulletsInBarrel count is the actual capacity of the barrel!
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {
        //•	totalBullets - int
        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        //o	If the total bullets are below zero, throw an IllegalArgumentException with message
        //"Total bullets cannot be below zero!"

        this.totalBullets = totalBullets;
    }

    protected void setCanFire(boolean canFire) {
        this.canFire = canFire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseGun baseGun = (BaseGun) o;
        return bulletsPerBarrel == baseGun.bulletsPerBarrel && totalBullets == baseGun.totalBullets && canFire == baseGun.canFire && Objects.equals(name, baseGun.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bulletsPerBarrel, totalBullets, canFire);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return canFire;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    @Override
    public int fire() {
        if (getTotalBullets() == 0) {
            setCanFire(false);
            return 0;
        }
        if (getTotalBullets() > 0) {
            setCanFire(true);
            setTotalBullets(getTotalBullets() - firePerFire);
            return firePerFire;
        }
        return 0;
    }

}