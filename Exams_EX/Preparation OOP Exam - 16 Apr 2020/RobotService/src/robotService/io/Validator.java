package robotService.io;

import robotService.models.garages.interfaces.Garage;

import static robotService.common.ExceptionMessages.INVALID_ROBOT_TYPE;
import static robotService.common.ExceptionMessages.NON_EXISTING_ROBOT;

public class Validator {
    private Validator(){
    }

    public static void isExistRobot(String name, Garage garage) {
        if (!garage.getRobots().containsKey(name)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, name));
        }
    }

    public static void wrongType(String robotType) {
        throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE,robotType));
    }
}
