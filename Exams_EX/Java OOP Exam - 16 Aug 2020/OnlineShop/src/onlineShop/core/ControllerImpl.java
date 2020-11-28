package onlineShop.core;

import onlineShop.core.Reposiytory.Repository;
import onlineShop.core.Reposiytory.RepositoryPC;
import onlineShop.core.Reposiytory.RepositoryComponent;
import onlineShop.core.Reposiytory.RepositoryPeripheral;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    Repository<Computer> computerRepository = new RepositoryPC<>();
    Repository<Component> componentRepository = new RepositoryComponent<>();
    Repository<Peripheral> peripheralRepository = new RepositoryPeripheral<>();

    public ControllerImpl() {
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        switch (computerType) {
            case "Laptop":
                computerRepository.addProduct(new Laptop(id, manufacturer, model, price));
                break;
            case "DesktopComputer":
                computerRepository.addProduct(new DesktopComputer(id, manufacturer, model, price));
                break;
            default:
                computerRepository.isInvalid();
        }

        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = computerRepository.getProductById(computerId);
        Component component = null;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                componentRepository.isInvalid();
        }
        componentRepository.addProduct(component);
        computer.addComponent(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        computerRepository.getProductById(computerId).removeComponent(componentType);
        return componentRepository.removeProduct(componentType);

    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = computerRepository.getProductById(computerId);
        Peripheral peripheral = null;
        switch (peripheralType) {
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                peripheralRepository.isInvalid();
        }
        peripheralRepository.addProduct(peripheral);
        computer.addPeripheral(peripheral);

        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        computerRepository.getProductById(computerId).removePeripheral(peripheralType);
        return peripheralRepository.removeProduct(peripheralType);
    }

    @Override
    public String buyComputer(int id) {
        return computerRepository.removeProduct(String.valueOf(id));
    }

    @Override
    public String BuyBestComputer(double budget) {

        return computerRepository.buyBestComputer(budget);
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = computerRepository.getProductById(id);
        return computer.toString();
    }
}
