package onlineShop.models.products;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.PRODUCT_TO_STRING;

public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    protected BaseProduct(int id, String manufacturer,
                          String model, double price, double overallPerformance) {
        setId(id);
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setOverallPerformance(overallPerformance);
    }

    public void setId(int id) {
        //o	cannot be less than or equal to 0. In that case, throw IllegalArgumentException with message "Id can not be less or equal than 0."
        if (id <= 0) {
            throw new IllegalArgumentException(INVALID_PRODUCT_ID);
        }
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        //o	cannot be null or whitespace. In that case, throw IllegalArgumentException with message "Manufacturer can not be empty."
        if (validateString(manufacturer)) {
            throw new IllegalArgumentException(INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }

    private boolean validateString(String string) {
        return string == null || string.trim().isEmpty();
    }


    public void setModel(String model) {
        //o	cannot be null or whitespace. In that case, throw IllegalArgumentException with message "Model can not be empty."
        if (validateString(model)) {
            throw new IllegalArgumentException(INVALID_MODEL);
        }
        this.model = model;
    }

    public void setPrice(double price) {
        //o	cannot be less than or equal to 0. In that case, throw IllegalArgumentException with message "Price can not be less or equal than 0."
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setOverallPerformance(double overallPerformance) {
        //o	cannot be less than or equal to 0. In that case, throw IllegalArgumentException with message "Overall Performance can not be less or equal than 0."
        if (overallPerformance <= 0) {
            throw new IllegalArgumentException(INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getOverallPerformance() {
        return overallPerformance;
    }

    @Override
    public String toString() {
        //"Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)";
        //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})"
        return String.format(PRODUCT_TO_STRING, this.getOverallPerformance(), this.getPrice(), this.getClass().getSimpleName()
                , this.getManufacturer(), this.getModel(), this.getId());
    }
}
