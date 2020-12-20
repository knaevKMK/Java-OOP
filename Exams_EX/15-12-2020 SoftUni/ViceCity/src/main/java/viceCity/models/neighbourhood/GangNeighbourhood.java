package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood {
    private boolean canFightMain;
    private boolean civilFight;

    public GangNeighbourhood() {
    }

    private void setCanFightMain(boolean canFightMain) {
        this.canFightMain = canFightMain;
    }

    private void setCivilFight(boolean civilFight) {
        this.civilFight = civilFight;
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        setCanFightMain(!mainPlayer.getGunRepository().getGuns().isEmpty());
        setCivilFight(canFire(civilPlayers));
        while (canFightMain || civilFight) {

            fireMainPlayer(mainPlayer, civilPlayers);
            if (!hasIliveCivils(civilPlayers)) {
                return;
            }
            fireCivilPlayer(mainPlayer, civilPlayers);
            if (mainPlayer.getLifePoints() == 0) {
                return;
            }
            setCivilFight(canFire(civilPlayers));
        }
    }

    private boolean canFire(Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getGunRepository().getGuns().stream().anyMatch(Gun::canFire)) {
                return true;
            }
        }
        return false;
    }


    private boolean hasIliveCivils(Collection<Player> civilPlayers) {
        return civilPlayers.stream().anyMatch(player -> player.getLifePoints() > 0);
    }

    private void fireCivilPlayer(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            if (mainPlayer.getLifePoints() == 0) {
                canFightMain = false;
                return;
            }
            Gun gun = (getGun(civilPlayer));
            if (gun == null) {
                continue;
            }

            int fire = gun.fire();
            mainPlayer.takeLifePoints(fire);
        }
    }

    private void fireMainPlayer(Player mainPlayer, Collection<Player> civilPlayers) {
        if (mainPlayer.getGunRepository().getGuns().isEmpty()) {
            setCanFightMain(false);
            return;
        }
        for (Player civilPlayer : civilPlayers) {
            while (civilPlayer.isAlive()) {
                Gun gun = getGun(mainPlayer);
                if (gun == null) {
                    return;
                }
                int fire = gun.fire();
                civilPlayer.takeLifePoints(fire);
            }
        }
    }

    private Gun getGun(Player player) {
        for (Gun gun : player.getGunRepository().getGuns()) {
            if (gun.canFire()) {
                return gun;
            }
        }
        return null;
    }

}
