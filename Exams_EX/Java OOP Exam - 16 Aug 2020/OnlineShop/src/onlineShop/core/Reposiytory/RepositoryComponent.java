package onlineShop.core.Reposiytory;

import onlineShop.models.products.components.Component;

import java.util.HashMap;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.EXISTING_COMPONENT_ID;
import static onlineShop.common.constants.ExceptionMessages.INVALID_COMPONENT_TYPE;
import static onlineShop.common.constants.OutputMessages.REMOVED_COMPONENT;

public class RepositoryComponent<T> implements Repository<Component> {
    private static Map<Integer, Component> components;

    public RepositoryComponent() {
        components = new HashMap<>();
    }


    @Override
    public void isExist(int id) {

    }

    @Override
    public void addProduct(Component product) {
        if (components.containsKey(product.getId())) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        components.put(product.getId(), product);
    }

    @Override
    public Component getProductById(int id) {
        return components.get(id);
    }

    @Override
    public void isInvalid() {
        throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
    }

    @Override
    public String removeProduct(String componentType) {
        for (Component value : components.values()) {
            if (value.getClass().getSimpleName().equals(componentType)) {
                components.remove(value.getId(), value);
                return String.format(REMOVED_COMPONENT, componentType, value.getId());
            }
        }
        return null;
    }

    @Override
    public String buyBestComputer(double budget) {
        return null;
    }
}
