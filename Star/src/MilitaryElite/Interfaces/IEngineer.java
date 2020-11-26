package MilitaryElite.Interfaces;

import MilitaryElite.Entities.Utilities.Repair;

import java.util.Collection;

public interface IEngineer  {//not extend?
    void addRepair(Repair repair);
    Collection<Repair> getRepair();
}
