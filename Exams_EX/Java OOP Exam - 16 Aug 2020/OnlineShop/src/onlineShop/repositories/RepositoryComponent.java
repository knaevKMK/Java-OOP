package onlineShop.repositories;

import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public class RepositoryComponent {
    private List<Component> components;

    public RepositoryComponent() {
        this.components = new ArrayList<>();
    }

    public Component getById(int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Component computer = this.isExist(id);
        if (computer != null) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        switch (componentType) {
            case "CentralProcessingUnit":
                return new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation) ;
            case "Motherboard":
                return new Motherboard(id, manufacturer, model, price, overallPerformance, generation) ;
            case "PowerSupply":
                return new PowerSupply(id, manufacturer, model, price, overallPerformance, generation) ;
            case "RandomAccessMemory":
                return new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation) ;
            case "SolidStateDrive":
                return new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation) ;
            case "VideoCard":
                return new VideoCard(id, manufacturer, model, price, overallPerformance, generation) ;
        }
       throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
    }

    private Component isExist(int id) {
        for (Component computer1 : components) {
            if (id == computer1.getId()) {
                return computer1;
            }
        }
        return null;
    }
}
