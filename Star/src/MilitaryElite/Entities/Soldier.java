package MilitaryElite.Entities;

import MilitaryElite.Interfaces.ISoldier;

public abstract class Soldier implements ISoldier {

    private int id;
    private String firstName;
    private String lastName;

    protected Soldier(String[] s) {
        this.id = Integer.parseInt(s[1]);
        this.firstName = s[2];
        this.lastName = s[3];
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s ", this.firstName, this.lastName, this.id);
    }
}
