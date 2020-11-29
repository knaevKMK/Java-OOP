package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_TYPE;

public class ControllerImpl implements Controller {
    private GunRepository gunRepository;
    private PlayerRepository playerRepository;
    private Field field;

    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.playerRepository = new PlayerRepository();
        field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun = null;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Pistol(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
        gunRepository.add(gun);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = gunRepository.findByName(gunName);
        Player player = null;
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        playerRepository.add(player);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start(playerRepository.getModels());
    }

    @Override
    public String report() {
        StringBuilder print = new StringBuilder();
        playerRepository.getModels().stream().filter(e -> e.getClass().getSimpleName().equals("CounterTerrorist"))
                .sorted(Comparator.comparing(Player::getUsername)).forEach(e -> print.append(e).append(System.lineSeparator()));
        playerRepository.getModels().stream().filter(e -> e.getClass().getSimpleName().equals("Terrorist"))
                .sorted(Comparator.comparing(Player::getUsername)).forEach(e -> print.append(e).append(System.lineSeparator()));
        return print.toString().trim();
    }
}
