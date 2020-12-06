package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.*;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;
import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_TYPE;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        return players
                .remove(player);
        //.removeIf(player1 -> player1.equals(player));
    }

    @Override
    public Player findByName(String name) {
        return players.stream().filter(player -> player.getUsername().equals(name)).findFirst().orElse(null);
    }

    public void isInvalid(String type) {
        throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
    }
}
