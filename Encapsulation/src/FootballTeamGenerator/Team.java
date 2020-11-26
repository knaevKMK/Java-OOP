package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> pLayers;

    public Team(String name) {
        setName(name);
        this.pLayers = new ArrayList<>();
    }

    private void setName(String name) {
        Validation.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.pLayers.add(player);
    }

    public void removePlayer(String playerName) {
        if (!this.pLayers.removeIf(player -> player.getName().equals(playerName))) {
            throw new IllegalArgumentException("Player " + playerName + " is not in " + this.getName() + " team.");
        }
    }

    public double getRating() {
        return  this.pLayers.stream().mapToDouble(Player::overallSkillLevel).sum();
    }
}
