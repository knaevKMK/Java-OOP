package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl<T> implements TableRepository<Table> {
    private Collection<Table> list;

    public TableRepositoryImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(this.list);
    }

    @Override
    public void add(Table table) {
        this.list.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        for (Table table : list) {
            if (table.getTableNumber() == number) {
                return table;
            }
        }
        return null;
    }
}
