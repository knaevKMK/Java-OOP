package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.ALREADY_REPAIRED;
import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public class Repair extends BaseProcedure {
    //o	doSerice()– removes 5 happiness and repairs current robot. Robot can be repaired once.
    // If robot is already repaired throw an IllegalArgumentException with message "{robotName} is already repaired"
    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.isRepaired()) {
            throw new IllegalArgumentException(String.format(ALREADY_REPAIRED, robot.getName()));
        }
        robot.setHappiness(robot.getHappiness() - 5);
        robot.setRepaired(true);
        super.doService(robot, procedureTime);
    }

}
