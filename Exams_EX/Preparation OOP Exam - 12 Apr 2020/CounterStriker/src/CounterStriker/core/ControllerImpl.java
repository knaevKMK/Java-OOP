package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import javax.swing.*;

import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private GunRepository gun;
    private PlayerRepository player;
    private Field field;

    public ControllerImpl() {
        this.gun = new GunRepository();
        this.player = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type) {
            case "Pistol":
                this.gun.add(new Pistol(name, bulletsCount));
                break;
            case "Rifle":
                this.gun.add(new Rifle(name, bulletsCount));
                break;
            default:
                this.gun.isInvalid(type);
        }
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player player = null;
        Gun gun = this.gun.findByName(gunName);
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                this.player.isInvalid(type);
        }
        this.player.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(player.getModels());
    }

    @Override
    public String report() {
        //Returns information about each player separated with a new line.

        StringBuilder print = new StringBuilder();
        player.getModels().stream().sorted((p, l) -> {
            int result = p.getClass().getSimpleName().compareTo(l.getClass().getSimpleName());  // Order them by type alphabetically,
            if (result == 0) {
                result = Integer.compare(l.getHealth(), p.getHealth());// then by health descending,
                if (result == 0) {
                    result = p.getUsername().compareTo(l.getUsername());
                    ;// then by username alphabetically.
                }
            }
            return result;
        })
                .forEach(pl -> print.append(pl).append(System.lineSeparator()));

        return print.toString().trim();
    }
}
