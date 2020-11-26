package MilitaryElite.Entities.Utilities;

import MilitaryElite.Enums.State;
import MilitaryElite.Interfaces.Utilities.IMission;

public class Mission implements IMission {
    private String name;
    private State state;

    public Mission(String name, State state) {
        this.name = name;
        this.state = state;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return "  Code Name: " + getName() + " State: " + getState().getDisplayText();

    }

}
