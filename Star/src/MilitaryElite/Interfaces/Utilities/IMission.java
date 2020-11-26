package MilitaryElite.Interfaces.Utilities;

import MilitaryElite.Enums.State;

public interface IMission {
    String getName();

    State getState();

    void completeMission();
}
