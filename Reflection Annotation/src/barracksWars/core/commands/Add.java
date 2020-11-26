package barracksWars.core.commands;

import barracksWars.core.Command;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;


    public Add() {
    }

    public Add(Repository repository, UnitFactory unitFactory, String[] data, Repository repository1, UnitFactory unitFactory1) {

        this.data = data;
        this.repository = repository1;
        this.unitFactory = unitFactory1;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = data[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }


}
