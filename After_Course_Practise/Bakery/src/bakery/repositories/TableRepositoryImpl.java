package bakery.repositories;

import bakery.entities.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {
    @Override
    public void add(Table model) {

    }

    @Override
    public Collection<Table> getAll() {
        return null;
    }

    @Override
    public Table getByNumber(int tableNumber) {
        return null;
    }
}
