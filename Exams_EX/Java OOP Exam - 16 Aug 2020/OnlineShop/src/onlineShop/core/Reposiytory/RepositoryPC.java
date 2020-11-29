package onlineShop.core.Reposiytory;

import onlineShop.models.products.computers.Computer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;

public class RepositoryPC<T> implements Repository<Computer> {
    private static Map<Integer, Computer> computers;

    public RepositoryPC() {
        this.computers = new HashMap<>();
    }

    public String buyBestComputer(double budget) {
        Computer bestComputer = computers.entrySet().stream()
                .filter(c -> c.getValue().getPrice() <= budget)
                .min((a, b) -> Double.compare(b.getValue().getOverallPerformance(), a.getValue().getOverallPerformance()))
                .orElseThrow().setValue(null);
        if (bestComputer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        computers.remove(bestComputer.getId(), bestComputer);
        return bestComputer.toString();
    }

    public void isInvalid() {
        throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);

    }

    @Override
    public String removeProduct(String id) {// parse it
        Computer computer = this.getProductById(Integer.parseInt(id));
//        if (computer == null) {
//            return "";
//        }
        computers.remove(Integer.parseInt(id), computer);
        return computer.toString();
    }

    @Override
    public void isExist(int id) {
//        if (computers.containsKey(id)) {
//            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
//        }
    }

    @Override
    public void addProduct(Computer product) {
        if (computers.containsKey(product.getId()) || computers.get(product.getId()) != null) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }

        computers.put(product.getId(), product);
    }

    @Override
    public Computer getProductById(int id) {
        if (!computers.containsKey(id) || computers.get(id) == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        return computers.get(id);
    }
}
