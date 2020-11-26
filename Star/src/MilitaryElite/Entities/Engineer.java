package MilitaryElite.Entities;

import MilitaryElite.Entities.Utilities.Repair;
import MilitaryElite.Interfaces.IEngineer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private List<Repair> repair;

    public Engineer(String[] s) {
        super(s);
        this.repair = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repair.add(repair);
    }

    @Override
    public Collection<Repair> getRepair() {
        return this.repair;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(super.toString() + System.lineSeparator() + "Repairs: " + System.lineSeparator());
        repair.forEach(k -> print.append(k.toString()).append(System.lineSeparator()));
        return print.toString().trim();
    }
}
