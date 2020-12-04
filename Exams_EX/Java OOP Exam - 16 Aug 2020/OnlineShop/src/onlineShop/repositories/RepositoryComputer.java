package onlineShop.repositories;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.Collection;

import static onlineShop.common.constants.ExceptionMessages.*;

public class RepositoryComputer {
    private Collection<Computer> computers;

    public RepositoryComputer() {
        this.computers = new ArrayList<>();
    }


    public void addComputer(Computer computer) {
        Computer computer1 = isExist(computer.getId());
        if (computer1 != null && computer.getId() == computer1.getId()) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        computers.add(computer);
    }


    public void invalidPC() {
        throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
    }

    public Computer getById(int id) {
        Computer computer = this.isExist(id);
        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        return computer;
    }

    private Computer isExist(int id) {
        for (Computer computer1 : computers) {
            if (id == computer1.getId()) {
                return computer1;
            }
        }
        return null;
    }

    public Computer remove(int id) {

        for (Computer computer1 : computers) {
            if (computer1.getId() == id) {
                computers.remove(computer1);
                return computer1;
            }
        }
        throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);

    }

    public Computer buyBestComputer(double budget) {
        Computer computer = computers.stream().filter(e -> e.getPrice() <= budget)
                .min((a, b) -> Double.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        computers.remove(computer);
        return computer;
    }
}
