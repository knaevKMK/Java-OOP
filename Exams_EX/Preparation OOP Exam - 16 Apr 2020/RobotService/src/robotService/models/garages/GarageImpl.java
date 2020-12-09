package robotService.models.garages;

import robotService.models.garages.interfaces.Garage;
import robotService.models.robots.interfaces.Robot;

import java.util.Map;
import java.util.TreeMap;

import static robotService.common.ExceptionMessages.*;

public class GarageImpl implements Garage {
    private final int CAPACITY = 10;
    private Map<String, Robot> robots;

    public GarageImpl() {
        this.robots = new TreeMap<>();
    }

    @Override
    public Map<String, Robot> getRobots() {
        return this.robots;
    }

    @Override
    public void manufacture(Robot robot) {
        checkCapacity();
        checkExistRobot(robot);
//If a robot with this name already exists in the garage, throw an IllegalArgumentException
// with the message "Robot {robot name} already exist"
//In any other case, add the current robot to the garage.
        this.robots.put(robot.getName(), robot);
    }

    private void checkExistRobot(Robot robot) {
        if (this.robots.containsKey(robot.getName())) {
            throw new IllegalArgumentException(String.format(EXISTING_ROBOT, robot.getName()));
        }
    }

    private void checkCapacity() {
        if (CAPACITY == this.robots.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void sell(String robotName, String ownerName) {
        Robot robot = getRobot(robotName);
        robot.setOwner(ownerName);
//If a robot with that name exists, change its owner,
        robot.setBought(true);
// its bought status
        this.robots.remove(robotName);
// and remove the robot from the garage.
    }

    private Robot getRobot(String robotName) {
        if (!this.robots.containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        return this.robots.get(robotName);
    }
}
