package onlineShop.common.validator;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

import static onlineShop.common.constants.ExceptionMessages.*;

public class Validator {
    private Validator() {
    }


    public static void validateComputerIsNotExist(Computer computer) {
        if (computer != null) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
    }

    public static void validateComputerIsExist(Computer computer) {
        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

    }


    public static void wrongComputerType() {
        throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
    }


    public static void wrongComponentType() {
        throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
    }



    public static void wrongPeriperalType() {
        throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
    }

    public static void validateCanBuyBestComputer(Computer bestComputer, double budget) {
        if (bestComputer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
    }
}
