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
        if (this.getArmor() != 0) {
            int result = this.getArmor() - points;
            if (result < 0) {
                this.setArmor(0);
                this.takeDamage(Math.abs(result));
            }
            this.setArmor(result);
            return;
        }
        if (this.getHealth() <= points) {
            this.setHealth(0);
            return;
        }
        this.setHealth(this.getHealth() - points);
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format("%s: %s", this.getClass().getSimpleName(), getUsername())).append(System.lineSeparator())
                .append(String.format("--Health: %d", getHealth())).append(System.lineSeparator())
                .append(String.format("--Armor: %d", getArmor())).append(System.lineSeparator())
                .append(String.format("--Gun: %s", getGun().getName()))
                .toString();

    }
}
