package MilitaryElite.Entities;

import MilitaryElite.Interfaces.IPrivate;

public class Private extends Soldier implements IPrivate {
    private Double salary;

    public Private(String[] s) {
        super(s);
        this.salary = Double.parseDouble(s[4]);
    }

    @Override
    public double getSalary() {
        return this.salary;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("Salary: %.2f", this.salary);
    }

}
