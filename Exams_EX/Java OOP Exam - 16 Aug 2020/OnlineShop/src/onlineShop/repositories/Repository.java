package onlineShop.repositories;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

public interface Repository {
    void addComputer(Computer computer);

    void addPeripheral(Peripheral peripheral);

    void addComponent(Component component);

    void invalidPC();

    Computer getComputerById(int computerId);
}
