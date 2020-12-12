package bakery.entities.tables;

import bakery.entities.tables.BaseTable;

public class InsideTable extends BaseTable {
    //InsideTable
    private static final double pricePerPerson = 2.50;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, pricePerPerson);
    }
}
