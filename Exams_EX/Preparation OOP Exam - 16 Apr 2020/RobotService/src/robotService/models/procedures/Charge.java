package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Charge extends BaseProcedure {
    @Override
    public void doService(Robot robot, int procedureTime) {
        //•	Charge class
        //o	doSerice() – adds 12 happiness and 10 energy
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() + 10);
        super.doService(robot, procedureTime);
    }

}
