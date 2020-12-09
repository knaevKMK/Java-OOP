package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure {

    @Override
    public void doService(Robot robot, int procedureTime) {
        //o	doSerice() – removes 6 energy and adds 12 happiness
        robot.setEnergy(robot.getEnergy() - 6);
        robot.setHappiness(robot.getHappiness() + 12);
        super.doService(robot, procedureTime);
    }

}
