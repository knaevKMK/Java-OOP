package robotService.models.robots;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {
    private String name;
    private int happiness;
    private int energy;
    private int procedureTime;
    private String owner;
    private boolean isBought;
    private boolean isRepaired;

    protected BaseRobot(String name, int happiness, int energy, int procedureTime) {
        this.name = name;
        setHappiness(happiness);
        setEnergy(energy);
        setProcedureTime(procedureTime);
        setOwner("Service");
        setBought(false);
        setRepaired(false);
    }

    private void validateInteger(int value, String exception) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(exception);
        }
    }

    @Override
    public void setHappiness(int happiness) {
        validateInteger(happiness, INVALID_HAPPINESS);
        this.happiness = happiness;
    }

    @Override
    public void setEnergy(int energy) {
        validateInteger(energy, INVALID_ENERGY);
        this.energy = energy;
    }


    @Override
    public void setProcedureTime(int procedureTime) {
  //      validateInteger(procedureTime,);
        this.procedureTime = procedureTime;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void setBought(boolean bought) {
//•	isBought – boolean
        this.isBought = bought;
    }

    @Override
    public void setRepaired(boolean repaired) {
//•	isRepaired – boolean
        this.isRepaired = repaired;
    }

    //getters

    public String getOwner() {
        return owner;
    }

    public boolean isBought() {
        return isBought;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getProcedureTime() {
        return procedureTime;
    }

    @Override
    public boolean isRepaired() {
        return isRepaired;
    }

    @Override
    public String toString() {
        return String.format(" Robot type: %s - %s - Happiness: %d - Energy: %d"
                , this.getClass().getSimpleName(), getName(), getHappiness(), getEnergy());
        //Note: There is a space in the beginning of the sentence!
    }
}
