package MilitaryElite.Entities.Utilities;

import MilitaryElite.Interfaces.Utilities.IRepair;

public class Repair implements IRepair {
    private String part;
    private int workTime;

    public Repair(String name, int time) {
        this.part = name;
        this.workTime = time;
    }

    @Override
    public String getPart() {
        return part;
    }

    @Override
    public int getWorkTime() {
        return workTime;
    }

    @Override
    public String toString() {
        return "  Part Name: " + getPart() + " Hours Worked: " + getWorkTime();
    }
}
