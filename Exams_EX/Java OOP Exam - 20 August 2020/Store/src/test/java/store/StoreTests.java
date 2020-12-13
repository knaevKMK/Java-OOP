package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreTests {
    private Store store;
    private Product product;

    private static final String PRODUCT_NAME = "Ivan";
    private static final int PRODUCT_quantity = 10;
    private static final double PRODUCT_price = 22;

    @Before
    public void setUp() {
        this.store = new Store();
        this.product = new Product(PRODUCT_NAME, PRODUCT_quantity, PRODUCT_price);
    }

    private void addProductTest() {
        this.store.addProduct(product);
    }

    // constructor
    @Test
    public void testCreate() {
        Assert.assertTrue(store.getProducts().isEmpty());
    }

    //    getList
    @Test
    public void testGetProductsEmptyList() {
        Assert.assertTrue(store.getProducts().isEmpty());
    }

    @Test
    public void testGetProductsNotEmptyList() {
        addProductTest();
        Assert.assertFalse(store.getProducts().isEmpty());
    }
//getCount

    @Test
    public void testGetCountReturn0() {
        Assert.assertEquals(0, store.getCount());
    }

    @Test
    public void testGetCountNonEmptyList() {
        addProductTest();
        Assert.assertEquals(1, store.getCount());
    }

    // addProduct
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullProduct() {
        this.store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidProduct() {
        this.store.addProduct(new Product(PRODUCT_NAME, -10, PRODUCT_price));
    }

    @Test
    public void testAddValidProduct() {
        int size = this.store.getCount();
        addProductTest();
        Assert.assertEquals(this.product, this.store.getProducts().get(0));
        Assert.assertEquals(size + 1, this.store.getProducts().size());
        Assert.assertFalse(this.store.getProducts().isEmpty());
    }

    // buyProduct
    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductIfNotExistName() {
        addProductTest();
        this.store.buyProduct("Miro", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductInvalidQuantity() {
   //     addProductTest();
        this.store.buyProduct(PRODUCT_NAME, -10);
    }

    @Test
    public void testBuyProductValidParam() {
        addProductTest();
        int testQuantity=5;
        double temp = PRODUCT_price * testQuantity;
        double result = this.store.buyProduct(PRODUCT_NAME, testQuantity);
        Assert.assertEquals(temp, result, 0.0);
       Assert.assertEquals(PRODUCT_quantity-testQuantity, this.product.getQuantity());
    }


    // getExpensiveProduct
    @Test
    public void testGetTheMostExpensiveProductIfExist() {
        addProductTest();
        this.store.addProduct(new Product("Miro", 9, 11));
        this.store.addProduct(new Product("Kiro", 8, 10));
        Assert.assertEquals(this.product, this.store.getTheMostExpensiveProduct());
        Assert.assertNotNull(this.store.getTheMostExpensiveProduct());

    }

    @Test
    public void testGetTheMostExpensiveProductIfNotExist() {
        Assert.assertNull(this.store.getTheMostExpensiveProduct());
    }
}