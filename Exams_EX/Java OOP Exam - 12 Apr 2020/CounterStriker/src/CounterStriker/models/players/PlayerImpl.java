package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String userName;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String userName, int health, int armor, Gun gun) {
        setUserName(userName);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    private void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.userName = userName;
    }

    private void setHealth(int health) {
        setAlive(health);
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setAlive(int health) {
        if (health > 0) {
            isAlive = true;
        } else {
            isAlive = false;
        }
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public Gun getGun() {
        return gun;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {
        int result = armor - points;
        if (result <= 0) {
            setArmor(0);
            if (health + result < 0) {
                setHealth(0);
                return;
            }
            setHealth(getHealth() + result);
            return;
        }
        setArmor(result);
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format("%s: %s%n", this.getClass().getSimpleName(), getUsername()))
                .append(String.format("--Health: %d%n", getHealth()))
                .append(String.format("--Armor: %d%n", getArmor()))
                .append(String.format("--Gun: %s", getGun().getName()))
                .toString();

    }
}
