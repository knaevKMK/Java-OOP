package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {
    private BankVault vault;
    private Item item;

    private String[] testKey;
    private static final String ITEM_OWNER = "Ivan";
    private static final String ITEM_ID = "1223ID";

    @Before
    public void setUp() {
        this.vault = new BankVault();
        this.item = new Item(ITEM_OWNER, ITEM_ID);
        testKey = new String[12];
        testKey[0] = "A1";
        testKey[1] = "A2";
        testKey[2] = "A3";
        testKey[3] = "A4";
        testKey[4] = "B1";
        testKey[5] = "B2";
        testKey[6] = "B3";
        testKey[7] = "B4";
        testKey[8] = "C1";
        testKey[9] = "C2";
        testKey[10] = "C3";
        testKey[11] = "C4";
    }

    // constructor
    @Test
    public void testCreateBankVault() {
        Assert.assertFalse(this.vault.getVaultCells().isEmpty());
        Assert.assertEquals(12, vault.getVaultCells().size());
    }

    @Test
    public void testCreateBankVaultByElelmnt() {
        Assert.assertFalse(this.vault.getVaultCells().isEmpty());
        for (String s : testKey) {
            Assert.assertTrue(this.vault.getVaultCells().containsKey(s));
            Assert.assertNull(this.vault.getVaultCells().get(s));
        }
    }


    //  getVaultCells
    @Test
    public void testGetVaultCells() throws OperationNotSupportedException {
        Assert.assertFalse(this.vault.getVaultCells().isEmpty());
        for (String s : testKey) {
            Assert.assertTrue(this.vault.getVaultCells().containsKey(s));
            Assert.assertNull(this.vault.getVaultCells().get(s));
        }

        this.vault.addItem("A1", item);
        Assert.assertTrue(this.vault.getVaultCells().containsValue(item));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCellsAsUnmodifiableCollection() {
        this.vault.getVaultCells().put("A1", this.item);
        this.vault.getVaultCells().remove("A1");
    }


    // addItem

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemInvalidCell() throws OperationNotSupportedException {
        //if (!this.vaultCells.containsKey(cell)) {
        //            throw new IllegalArgumentException("Cell doesn't exist!");
        //        }
        this.vault.addItem(ITEM_ID, item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemValidItemOnExistCellValue() throws OperationNotSupportedException {
        //  if (this.vaultCells.get(cell) != null) {
        //            throw new IllegalArgumentException("Cell is already taken!");
        //        }
        this.vault.addItem("A1", this.item);
        this.vault.addItem("A1", new Item("Pesho", "Gosho"));

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemExistItem() throws OperationNotSupportedException {
        //  if (itemExist) {
        //            throw new OperationNotSupportedException("Item is already in cell");
        //        }
        this.vault.addItem("A1", this.item);
        this.vault.addItem("A2", this.item);

    }

    @Test
    public void testAddItemValidNonExistItem() throws OperationNotSupportedException {

        String result = String.format("Item:%s saved successfully!", item.getItemId());
        Assert.assertEquals(result, this.vault.addItem("A1", this.item));
        Assert.assertEquals(this.item, this.vault.getVaultCells().get("A1"));
        Assert.assertNotNull(this.vault.getVaultCells().get("A1"));

    }


    // removeItem by Cell & item -> String

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemNotExistCell() {
        // if (!this.vaultCells.containsKey(cell)) {
        //            throw new IllegalArgumentException("Cell doesn't exists!");
        //        }
        this.vault.removeItem(ITEM_ID, this.item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemNotExistItem() throws OperationNotSupportedException {
        //        if (this.vaultCells.get(cell) != item) {
        // throw new IllegalArgumentException("Item in that cell doesn't exists!");
        //}
        this.vault.addItem("A1", new Item("Baba", "Pena"));
        this.vault.removeItem("A1", this.item);
    }

    @Test
    public void testRemoveItemValidParam() throws OperationNotSupportedException {
        this.vault.addItem("A1", this.item);
        String temp = String.format("Remove item:%s successfully!", item.getItemId());
        Assert.assertEquals(temp, this.vault.removeItem("A1", this.item));
        Assert.assertNull(this.vault.getVaultCells().get("A1"));
    }

}