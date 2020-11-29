package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {
    public FieldImpl() {
    }

    @Override
    public String start(Collection<Player> players) {
        //Separates the players in two types - Terrorist and Counter Terrorist.
        List<Player> terrorsits = getList("Terrorist", players);
        List<Player> counterTerrorist = getList("CounterTerrorist", players);

        while (true) {
            attack(terrorsits, counterTerrorist);
            if (teamIsAlive(counterTerrorist)) {
                return "Terrorist wins!";
            }

            attack(counterTerrorist, terrorsits);
            if (teamIsAlive(terrorsits)) {
                return "Counter Terrorist wins!";
            }
        }
        // The game continues until one of the teams is completely dead (all players have 0 health).
        // The terrorists attack first and after that the counter terrorists.
        // The attack happens like that: Each live terrorist shoots on each live counter terrorist
        // once and inflicts damage equal to the bullets fired and after that each live counter terrorist shoots on each live terrorist.
        //If Terrorists win returns "Terrorist wins!"
        // otherwise returns "Counter Terrorist wins!"
    }

    private boolean teamIsAlive(List<Player> team) {
        return team.stream().noneMatch(Player::isAlive);
    }

    private void attack(List<Player> teamAttack, List<Player> attackedTeam) {
        for (Player attacker : teamAttack) {
            if (attacker.isAlive()) {
                for (Player attacked : attackedTeam) {
                    if (attacked.isAlive()) {
                        attacked.takeDamage(attacker.getGun().fire());
                    }
                }
            }
        }
    }

    private List<Player> getList(String playersType, Collection<Player> players) {
        return players.stream().filter(e -> e.getClass().getSimpleName().equals(playersType)).collect(Collectors.toList());
    }
}
