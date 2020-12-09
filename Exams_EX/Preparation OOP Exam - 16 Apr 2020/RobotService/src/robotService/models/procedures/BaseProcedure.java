package robotService.models.procedures;

import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public abstract class BaseProcedure implements Procedure {
    private Collection<Robot> robots;

    protected BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        StringBuilder print = new StringBuilder(this.getClass().getSimpleName()).append(System.lineSeparator());
        this.robots.forEach(robot -> print.append(robot).append(System.lineSeparator()));
        return print.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        this.robots.add(robot);
//NOTE: Every time when doService() method has called,
// current robot is added to the robot's collection and the time
// the procedure took is subtracted from the robot’s allowed procedure time.
    }

}
