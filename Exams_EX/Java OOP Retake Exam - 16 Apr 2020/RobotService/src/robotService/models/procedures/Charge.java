package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.ALREADY_REPAIRED;

public class Charge extends BaseProcedure {
    //•	Charge class
    //o	doSerice() – adds 12 happiness and 10 energy
    @Override
    public void doService(Robot robot, int procedureTime) {
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() + 10);
        super.doService(robot, procedureTime);
    }
}
