package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.Peripheral;
import onlineShop.repositories.Repository;
import onlineShop.repositories.RepositoryComponent;
import onlineShop.repositories.RepositoryComputer;
import onlineShop.repositories.RepositoryPeripheral;

import java.util.Comparator;

import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private RepositoryComputer pcRepo;
    private RepositoryComponent componentRepo;
    private RepositoryPeripheral peripheralRepo;

    public ControllerImpl() {
        this.pcRepo = new RepositoryComputer();
        componentRepo = new RepositoryComponent();
        peripheralRepo = new RepositoryPeripheral();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        switch (computerType) {
            case "DesktopComputer":
                pcRepo.addComputer(new DesktopComputer(id, manufacturer, model, price));
                break;
            case "Laptop":
                pcRepo.addComputer(new Laptop(id, manufacturer, model, price));
                break;
            default:
                pcRepo.invalidPC();
        }
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = pcRepo.getById(computerId);
        Peripheral component = peripheralRepo.getById(id, peripheralType, manufacturer, model, price, overallPerformance, connectionType);
        computer.addPeripheral(component);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = pcRepo.getById(computerId);
        Peripheral component = computer.removePeripheral(peripheralType);
        return String.format(REMOVED_PERIPHERAL, peripheralType, component.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = pcRepo.getById(computerId);
        Component component = componentRepo.getById(id, componentType, manufacturer, model, price, overallPerformance, generation);
        computer.addComponent(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = pcRepo.getById(computerId);
        Component component = computer.removeComponent(componentType);
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = pcRepo.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = pcRepo.buyBestComputer(budget);
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = pcRepo.getById(id);
        return computer.toString();
    }
}
