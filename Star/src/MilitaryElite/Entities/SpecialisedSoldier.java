package MilitaryElite.Entities;

import MilitaryElite.Enums.Corps;
import MilitaryElite.Interfaces.ISpecialisedSoldier;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private Corps corps;

    protected SpecialisedSoldier(String[] s) {
        super(s);
        this.corps = Corps.valueOf(s[5].toUpperCase());
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Corps: " + this.getCorps().getDisplayString();
    }
}
