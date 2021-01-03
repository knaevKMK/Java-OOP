package bakery.repositories.interfaces;

import bakery.entities.interfaces.Table;

public interface TableRepository<T> extends Repository <Table>{
    T getByNumber(int tableNumber);
}
