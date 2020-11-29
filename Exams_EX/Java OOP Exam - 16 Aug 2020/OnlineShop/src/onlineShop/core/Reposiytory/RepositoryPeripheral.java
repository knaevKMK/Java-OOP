package onlineShop.core.Reposiytory;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.HashMap;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.EXISTING_PERIPHERAL_ID;
import static onlineShop.common.constants.ExceptionMessages.INVALID_PERIPHERAL_TYPE;
import static onlineShop.common.constants.OutputMessages.REMOVED_COMPONENT;
import static onlineShop.common.constants.OutputMessages.REMOVED_PERIPHERAL;

public class RepositoryPeripheral<T> implements Repository<Peripheral> {
    private Map<Integer, Peripheral> peripherals;

    public RepositoryPeripheral() {
        this.peripherals = new HashMap<>();
    }

    @Override
    public void isExist(int id) {

    }

    @Override
    public void addProduct(Peripheral product) {
        if (peripherals.containsKey(product.getId()) || peripherals.get(product.getId()) != null) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        peripherals.put(product.getId(), product);
    }

    @Override
    public Peripheral getProductById(int id) {

        return peripherals.get(id);
    }

    @Override
    public void isInvalid() {
        throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
    }

    @Override
    public String removeProduct(String typeType) {
        for (Peripheral value : peripherals.values()) {
            if (value.getClass().getSimpleName().equals(typeType)) {
                peripherals.remove(value.getId(), value);
                return String.format(REMOVED_PERIPHERAL, typeType, value.getId());
            }
        }
        return null;
    }

    @Override
    public String buyBestComputer(double budget) {
        return null;
    }
}
