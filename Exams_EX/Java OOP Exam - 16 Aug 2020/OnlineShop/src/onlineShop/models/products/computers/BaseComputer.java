package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;

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
        if (containsComponent(component)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        components.add(component);
    }

    protected boolean containsComponent(Component component) {
        for (Component component1 : components) {
            if (component.equals(component1)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Component removeComponent(String componentType) {
        for (Component component : components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                components.remove(component);
                return component;
            }

        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT
                , componentType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (containsPeripheral(peripheral)) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        peripherals.add(peripheral);
    }

    protected boolean containsPeripheral(Peripheral peripheral) {
        for (Peripheral component1 : peripherals) {
            if (peripheral.equals(component1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        for (Peripheral component : peripherals) {
            if (component.getClass().getSimpleName().equals(peripheralType)) {
                peripherals.remove(component);
                return component;
            }

        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL
                , peripheralType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public double getPrice() {
        return super.getPrice() + components.stream().mapToDouble(Product::getPrice).sum()
                + peripherals.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        }
        return super.getOverallPerformance() + components.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0.0);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(super.toString()
                + System.lineSeparator());
        print.append(" ")
                .append(String.format(COMPUTER_COMPONENTS_TO_STRING, components.size()))
                .append(System.lineSeparator());
        components.forEach(e -> print.append("  ").append(e).append(System.lineSeparator()));
        print.append(" ")
                .append(String.format(COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), getAveregeOverallPerformancePeripherals()))
                .append(System.lineSeparator());
        peripherals.forEach(e -> print.append("  ").append(e).append(System.lineSeparator()));
        return print.toString().trim();
    }

    private double getAveregeOverallPerformancePeripherals() {
        return peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0.0);
    }
}
