package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Collection<Player> civilList;
    private Player mainPLayer;
    private ArrayDeque<Gun> gunRepo;
    private Neighbourhood game;

    public ControllerImpl() {
        this.civilList = new ArrayList<>();
        this.mainPLayer = new MainPlayer();
        this.gunRepo = new ArrayDeque<>();
        game = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        civilList.add(civilPlayer);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        this.gunRepo.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        if (this.gunRepo.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = gunRepo.peek();

        //Adds the first added gun to the player's gun repository.
        //•	If there no guns in the queue, return the following message:
        //"There are no guns in the queue!"
        if (name.equals("Vercetti")) {
            mainPLayer.getGunRepository().add(gun);
            gunRepo.poll();
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPLayer.getName());
        }
        //•	If the name of the player is "Vercetti", you need to add the gun to the main player's repository
        // and return the following message:
        //"Successfully added {gun name} to the Main Player: Tommy Vercetti"

        Player player = findPlayerByName(name);
        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        //•	If you receive a name which doesn't exist, you should return the following message:
        //"Civil player with that name doesn't exists!"
        player.getGunRepository().add(gun);
        gunRepo.poll();
        //•	If everything is successful, you should add the gun to the player's repository and return the following message:
        //"Successfully added {gun name} to the Civil Player: {player name}"
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
    }

    private Player findPlayerByName(String name) {
        for (Player player : civilList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public String fight() {
        //When the fight command is called, the action happens. You should start the action between the main player and all the civil players.
        game.action(mainPLayer, civilList);
        if (mainPLayer.getLifePoints() == 100 && civilList.stream().allMatch(player -> player.getLifePoints() >0)) {
            return FIGHT_HOT_HAPPENED;
        }

        //•	If the main player still has all of his points
        // and no one is dead or harmed from the civil players, you should return the following messages:
        //"Everything is okay!"
        long killed = this.civilList.stream().filter(player -> !player.isAlive()).count();

        StringBuilder print = new StringBuilder(FIGHT_HAPPENED).append(System.lineSeparator());
        print.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPLayer.getLifePoints())).append(System.lineSeparator());
        print.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killed)).append(System.lineSeparator());
        print.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, this.civilList.size() - killed));
        return print.toString();
    }
}
