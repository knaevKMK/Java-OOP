package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import java.util.Objects;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String userName, int health, int armor, Gun gun) {
        setUsername(userName);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            //o	If the username is null or whitespace,
            throw new NullPointerException(INVALID_PLAYER_NAME);
            // throw a NullPointerException with message: "Username cannot be null or empty."
        }
        this.username = username;
    }

    private void setHealth(int health) {
        //o	If the health is below 0,
        setAlive(health > 0);
        if (health < 0) {
            // throw an IllegalArgumentException with message: "Player health cannot be below 0."
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }

        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            // throw an IllegalArgumentException with message: "Player health cannot be below 0."
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        //o	If the armor is below 0, throw an IllegalArgumentException with message:
        // "Player armor cannot be below 0."

        this.armor = armor;
    }

    private void setAlive(boolean isAlive) {
        this.isAlive = isAlive;

    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        //o	If the gun is null, throw a NullPointerException with message:
        // "Gun cannot be null."
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return username;
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
//        int result = armor - points;
//        if (result <= 0) {
//            setArmor(0);
//            if (health + result <= 0) {
//                setHealth(0);
//                return;
//            }
//            setHealth(getHealth() + result);
//        } else {
//            setArmor(result);
//        }
//        //The takeDamage() method decreases the Player's armor and health.
//        // First you need to reduce the armor.
//        // If the armor reaches 0, transfer the damage to health points.
//// If the health points are less than or equal to zero, the player is dead.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerImpl player = (PlayerImpl) o;
        return Objects.equals(username, player.username);
    }


    @Override
    public String toString() {
        return new StringBuilder(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()))   //"{player type}: {player username}
                .append(System.lineSeparator())
                .append(String.format("--Health: %d", this.getHealth())).append(System.lineSeparator())
                .append(String.format("--Armor: %d", this.getArmor())).append(System.lineSeparator())
                .append(String.format("--Gun: %s", this.getGun().getName()))
                .toString();
    }
}
