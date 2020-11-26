package MilitaryElite.Entities;

import MilitaryElite.Entities.Utilities.Mission;
import MilitaryElite.Interfaces.ICommando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<Mission> missions;

    public Commando(String... s) {
        super(s);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(super.toString() + System.lineSeparator() + "Missions: " + System.lineSeparator());
        this.missions.forEach(v -> print.append(v.toString()).append(System.lineSeparator()));
        return print.toString().trim();
    }
}
