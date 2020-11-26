package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Report implements Executable {
    private Repository repository;

    protected Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
