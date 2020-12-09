package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.io.Validator;
import robotService.models.garages.GarageImpl;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.Charge;
import robotService.models.procedures.Repair;
import robotService.models.procedures.Work;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.Cleaner;
import robotService.models.robots.Housekeeper;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.NON_EXISTING_ROBOT;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    //NOTE: For each command except for "Manufacture" and "History",
    // you must check if a robot with that name exist in the garage.
    private Robot getRobot(String name) {
        Validator.isExistRobot(name, this.garage);
        return this.garage.getRobots().get(name);
    }


    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        Robot robot = null;
        switch (robotType) {
            case "Housekeeper":
                robot = new Housekeeper(name, happiness, energy, procedureTime);
                break;
            case "Cleaner":
                robot = new Cleaner(name, happiness, energy, procedureTime);
                break;
            default:
                Validator.wrongType(robotType);
        }
        this.garage.manufacture(robot);
        return String.format(ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        Robot robot = getRobot(robotName);
        repair.doService(robot, procedureTime);
        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        Robot robot = getRobot(robotName);
        work.doService(robot, procedureTime);
        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        Robot robot = getRobot(robotName);
        charge.doService(robot, procedureTime);
        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        Robot robot = getRobot(robotName);
        this.garage.sell(robotName, ownerName);
        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        switch (procedureType) {
            case "Charge":
                return this.charge.history();
            case "Work":
                return this.work.history();
            case "Repair":
                return this.repair.history();
        }
        return null;
    }
}
