package robotService.models.garages;

import robotService.models.garages.interfaces.Garage;
import robotService.models.robots.interfaces.Robot;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static robotService.common.ExceptionMessages.*;

public class GarageImpl implements Garage {
    private static final int CAPACITY = 10;
    private Map<String, Robot> robots;

    public GarageImpl() {
        this.robots = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Robot> getRobots() {
        return Collections.unmodifiableMap(robots);
    }

    @Override
    public void manufacture(Robot robot) {
        if (robots.size() == CAPACITY) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }//If there isn't enough capacity in the garage throw an IllegalStateException with the message "Not enough capacity"
        if (robots.containsKey(robot.getName())) {
            throw new IllegalArgumentException(String.format(EXISTING_ROBOT, robot.getName()));
        }
//If a robot with this name already exists in the garage, throw an IllegalArgumentException with the message "Robot {robot name} already exist"
        robots.put(robot.getName(), robot);
//In any other case, add the current robot to the garage.
    }

    @Override
    public void sell(String robotName, String ownerName) {
        if (!robots.containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
//If the provided robot name does not exist in the garage, throw an IllegalArgumentException with the message "Robot {robot name} does not exist"
        Robot robot = robots.get(robotName);
        robot.setOwner(ownerName);
        robot.setBought(true);
        robots.remove(robotName);
//If a robot with that name exists, change its owner, its bought status and remove the robot from the garage.
    }

}
