package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(8, 9, 10);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test_setElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void Test_setElementsShouldTWorkProperly() throws OperationNotSupportedException {

        Integer[] elements = database.getElements();
        Integer[] actual = new Integer[]{8, 9, 10};

        Assert.assertArrayEquals(elements, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldWorkProperly() throws OperationNotSupportedException {
        Integer value = 11;
        int expectedLenght = database.getElements().length+1;
        database.add(value);

        Assert.assertEquals(expectedLenght, database.getElements().length);
//        Assert.assertEquals(value, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
    }

    @Test
    public void testRemoveShouldWorkProperly() throws OperationNotSupportedException {
        Integer value = 11;
        int expectedLenght = database.getElements().length-1;
        database.remove();

        Assert.assertEquals(expectedLenght, database.getElements().length);
 //       Assert.assertEquals(value, database.getElements()[database.getElements().length - 1]);
    }


    @Test
    public void testGetElementsShouldWorkProperly() {
        Integer [] expected= {8,9,10};
        Assert.assertArrayEquals(expected,database.getElements());
    }
}