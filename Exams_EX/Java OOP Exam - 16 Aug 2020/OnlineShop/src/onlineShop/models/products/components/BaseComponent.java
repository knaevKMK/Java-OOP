package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

import java.util.Objects;

import static onlineShop.common.constants.OutputMessages.COMPONENT_TO_STRING;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    @Override
    public int getGeneration() {
        return generation;
    }

    protected BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }


    public boolean equals(Component component) {
        if (this == component) return true;
        if (component == null || getClass() != component.getClass()) return false;
        BaseComponent that = (BaseComponent) component;
        return generation == that.generation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(generation);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(COMPONENT_TO_STRING, getGeneration());
    }
}
