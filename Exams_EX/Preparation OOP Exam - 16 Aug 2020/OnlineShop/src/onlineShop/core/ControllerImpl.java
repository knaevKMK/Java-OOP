package onlineShop.core;

import onlineShop.common.validator.Validator;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
//    private List<Component> components;
//    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
//        this.components = new ArrayList<>();
//        this.peripherals = new ArrayList<>();
    }

    public Computer isExistComputerById(int id) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                return computer;
            }
        }
        return null;
    }
    //NOTE: For each command, except for "addComputer" and "buyBest", you must check
    // if a computer, with that id, exists in the computers collection.
    // If it doesn't, throw an IllegalArgumentException with the message "Computer with this id does not exist.".

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Validator.validateComputerIsNotExist(isExistComputerById(id));
        Computer computer = null;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                Validator.wrongComputerType();
        }
        this.computers.add(computer);
        return String.format(ADDED_COMPUTER, id);
    }

    private Peripheral isExistPeriperalById(int id, Computer computer) {
        for (Peripheral peripheral : computer.getPeripherals()) {
            if (peripheral.getId() == id) {
                return peripheral;
            }
        }
        return null;
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = this.isExistComputerById(computerId);
        Validator.validateComputerIsExist(computer);
        switch (peripheralType) {
            case "Headset":
                computer.addPeripheral(new Headset(id, manufacturer, model, price, overallPerformance, connectionType));
                break;
            case "Keyboard":
                computer.addPeripheral(new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType));
                break;
            case "Monitor":
                computer.addPeripheral(new Monitor(id, manufacturer, model, price, overallPerformance, connectionType));
                break;
            case "Mouse":
                computer.addPeripheral(new Mouse(id, manufacturer, model, price, overallPerformance, connectionType));
                break;
            default:
                Validator.wrongPeriperalType();
        }
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = this.isExistComputerById(computerId);
        Validator.validateComputerIsExist(computer);
        Peripheral peripheral = computer.removePeripheral(peripheralType);
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    private Component isExistComponentById(int id, Computer computer) {
        for (Component component : computer.getComponents()) {
            if (component.getId() == id) {
                return component;
            }
        }
        return null;
    }

    @Override
    public String addComponent(int computerId, int id, String componentType,
                               String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = this.isExistComputerById(computerId);
        Validator.validateComputerIsExist(computer);

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = (new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation));
                break;
            case "Motherboard":
                component = (new Motherboard(id, manufacturer, model, price, overallPerformance, generation));
                break;
            case "PowerSupply":
                component = (new PowerSupply(id, manufacturer, model, price, overallPerformance, generation));
                break;
            case "RandomAccessMemory":
                component = (new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation));
                break;
            case "SolidStateDrive":
                component = (new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation));
                break;
            case "VideoCard":
                component = (new VideoCard(id, manufacturer, model, price, overallPerformance, generation));
                break;
            default:
                component = null;
                Validator.wrongComponentType();
                break;
        }
      computer.addComponent(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = this.isExistComputerById(computerId);
        Validator.validateComputerIsExist(computer);
        Component component = computer.removeComponent(componentType);
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = this.isExistComputerById(id);
        Validator.validateComputerIsExist(computer);
        this.computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer bestComputer = this.computers.stream()
                .filter(computer -> computer.getPrice() <= budget)
                .min((a, b) -> Double.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .orElse(null);
        Validator.validateCanBuyBestComputer(bestComputer, budget);
        return bestComputer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = this.isExistComputerById(id);
        Validator.validateComputerIsExist(computer);
        return computer.toString();
    }
}
