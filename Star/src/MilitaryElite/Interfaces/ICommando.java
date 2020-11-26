package MilitaryElite.Interfaces;

import MilitaryElite.Entities.Utilities.Mission;

import java.util.Collection;

public interface ICommando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
