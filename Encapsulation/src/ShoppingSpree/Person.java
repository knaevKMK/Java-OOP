package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    //name, money and a bag of products
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        checkFunds(product);
        this.products.add(product);
        this.setMoney(this.money - product.getCost());
    }

    private void checkFunds(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(this.name).append(" - ");

        if (this.products.isEmpty()) {
            return print.append("Nothing bought").append(System.lineSeparator()).toString();
        }

        products.forEach(product -> print.append(product.getName()).append(", "));

        return print.substring(0, print.length() - 2).toString();
    }
}

