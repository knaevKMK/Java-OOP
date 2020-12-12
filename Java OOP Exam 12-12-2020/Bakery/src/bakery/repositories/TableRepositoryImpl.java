package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.WRONG_TABLE_NUMBER;

public class TableRepositoryImpl<T> implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Table table) {
        //If a drink with the given name already exists in the drink repository,
        // throw an IllegalArgumentException with message "Table {tableNumber} is already added to the restaurant"
        for (Table model : models) {
            if (model.getTableNumber() == table.getTableNumber()) {
                throw new IllegalArgumentException(String.format(TABLE_EXIST, table.getTableNumber()));
            }
        }
        this.models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        for (Table table : models) {
            if (table.getTableNumber() == number) {
                return table;
            }
        }
        return null;
    }
}
