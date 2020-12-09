package onlineShop.models.products.computers;

import onlineShop.common.validator.Validator;
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

        if (isExistComponentById(component)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        if (isExistComponentByType(component)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), getId()));
        }

        this.components.add(component);
    }

    private boolean isExistComponentById(Component component) {
        for (Component component1 : components) {
            if (component.getId() == component1.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistComponentByType(Component type) {
        for (Component component : getComponents()) {
            if (component.getClass().getSimpleName().equals(type.getClass().getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Component removeComponent(String componentType) {
        for (Component component : getComponents()) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                this.components.remove(component);
                return component;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

        if (isExistPeripheralById(peripheral)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        if (isExistPeriperalByType(peripheral)) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), getId()));
        }
        this.peripherals.add(peripheral);
    }

    public boolean isExistPeriperalByType(Peripheral type) {
        for (Peripheral peripheral : getPeripherals()) {
            if (peripheral.getClass().getSimpleName().equals(type.getClass().getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistPeripheralById(Peripheral peripheral) {
        for (Peripheral peripheral1 : peripherals) {
            if (peripheral.getId() == peripheral1.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        for (Peripheral peripheral : this.peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                this.peripherals.remove(peripheral);
                return peripheral;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), getId()));
    }

    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() + this.getComponents().stream().mapToDouble(Product::getOverallPerformance).average().orElse(0);
    }

    @Override
    public double getPrice() {
        return super.getPrice()
                + getComponents().stream().mapToDouble(Product::getPrice).sum()
                + getPeripherals().stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(super.toString()).append(System.lineSeparator());

        print.append(" ").append(String.format(COMPUTER_COMPONENTS_TO_STRING, getComponents().size())).append(System.lineSeparator());

        getComponents().forEach(component -> print.append("  ").append(component).append(System.lineSeparator()));

        print.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING,
                getPeripherals().size(), getAveragePerperalsOverallPerformence()))
                .append(System.lineSeparator());

        getPeripherals().forEach(peripheral -> print.append("  ").append(peripheral).append(System.lineSeparator()));

        return print.toString().trim();
    }

    private double getAveragePerperalsOverallPerformence() {
        return getPeripherals().stream().mapToDouble(Product::getOverallPerformance).average().orElse(0.0);
    }

}
