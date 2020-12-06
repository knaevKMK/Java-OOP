package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {
    private Collection<Player> terrorists;
    private Collection<Player> counterTerrorists;

    public FieldImpl() {
        this.terrorists = new ArrayList<>();
        this.counterTerrorists = new ArrayList<>();
    }

    public Collection<Player> getTerrorists() {
        return Collections.unmodifiableCollection(terrorists);
    }

    public Collection<Player> getCounterTerrorists() {
        return Collections.unmodifiableCollection(counterTerrorists);
    }

    @Override
    public String start(Collection<Player> players) {
        // Separates the players in two types - Terrorist and Counter Terrorist.
        this.terrorists = getPlayers("Terrorist", players);
        this.counterTerrorists = getPlayers("CounterTerrorist", players);
        while (true) {
            attacke(terrorists, counterTerrorists);
            if (hasAlive(counterTerrorists)) {
                return TERRORIST_WINS;
            }
            attacke(counterTerrorists, terrorists);
            if (hasAlive(terrorists)) {
                return COUNTER_TERRORIST_WINS;
            }
        }
    }

    private void attacke(Collection<Player> attackers, Collection<Player> attacked) {
        // The terrorists attack first and after that the counter terrorists.
        for (Player attacker : attackers) {
            if (attacker.isAlive()) {
                for (Player player : attacked) {
                    if (player.isAlive()) {
                        int fire = attacker.getGun().fire();
                        player.takeDamage(fire);
                    }
                }
            }
        }
    }

    private boolean hasAlive(Collection<Player> players) {
        return players.stream().noneMatch(Player::isAlive);
    }

    private List<Player> getPlayers(String type, Collection<Player> players) {
        return players.stream()
                .filter(player -> player.getClass().getSimpleName().equals(type))
                .collect(Collectors.toList());
    }

}
