package onlineShop.repositories;


import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public class RepositoryPeripheral {
    private List<Peripheral> peripherals;

    public RepositoryPeripheral() {
        this.peripherals = new ArrayList<>();
    }

    public Peripheral getById(int id, String peripheralType, String manufacturer, String model, double price,
                              double overallPerformance, String connectionType) {
        Peripheral computer = this.isExist(id);
        if (computer != null) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        switch (peripheralType) {
            case "Headset":
                return new Headset(id, manufacturer, model, price, overallPerformance, connectionType) ;
            case "Keyboard":
                return new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType) ;
            case "Monitor":
                return new Monitor(id, manufacturer, model, price, overallPerformance, connectionType) ;
            case "Mouse":
                return new Mouse(id, manufacturer, model, price, overallPerformance, connectionType) ;

        }
        throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
    }

    private Peripheral isExist(int id) {
        for (Peripheral computer1 : peripherals) {
            if (id == computer1.getId()) {
                return computer1;
            }
        }
        return null;

    }
}
