package MilitaryElite.Entities;

import MilitaryElite.Interfaces.ISpy;

public class Spy extends Soldier implements ISpy {
    private String codeNumber;

    public Spy(String[] s) {
        super(s);
        this.codeNumber = s[4];
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Code Number: " + this.codeNumber;
    }
}
