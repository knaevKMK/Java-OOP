package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for (Component component1 : components) {
            if (component1.getClass().getSimpleName()
                    .equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                        component.getClass().getSimpleName(), this.getClass().getSimpleName()
                        , getId()));
            }
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        for (Component component : components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                components.remove(component);
                return component;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral component1 : peripherals) {
            if (component1.getClass().getSimpleName()
                    .equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                        peripheral.getClass().getSimpleName(), this.getClass().getSimpleName()
                        , getId()));
            }
        }
        peripherals.add(peripheral);

    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                peripherals.remove(peripheral);
                return peripheral;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public double getPrice() {
        return super.getPrice() + components.stream().mapToDouble(Product::getPrice).sum()
                + peripherals.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public double getOverallPerformance() {
        if (!components.isEmpty()) {
            return super.getOverallPerformance() + components.stream().mapToDouble(Product::getOverallPerformance)
                    .average().orElse(0.0);
        }
        return super.getOverallPerformance();
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(super.toString())
                .append(System.lineSeparator())
                .append(String.format(" Components (%d):", components.size()))
                .append(System.lineSeparator());
        components.forEach(e -> print.append("  ").append(e).append(System.lineSeparator()));
        print.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", peripherals.size(), peripheralsAverageOverallPerformance()))
                .append(System.lineSeparator());
        peripherals.forEach(e -> print.append("  ").append(e).append(System.lineSeparator()));

        return print.toString().trim();
    }

    protected double peripheralsAverageOverallPerformance() {
        return peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0.0);
    }

}
