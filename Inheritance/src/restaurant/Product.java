package restaurant;

import java.math.BigDecimal;

public class Product {
    private String name;   // •	name – String
    private BigDecimal price;//•	price – BigDecimal
    //•	Getters for the fields

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {

        return price;
    }
}
