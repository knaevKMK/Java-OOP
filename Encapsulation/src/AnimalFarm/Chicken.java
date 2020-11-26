package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.length() < 1 || name.equals("\\s+")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.getName()
                , this.getAge(), this.productPerDay());
    }

    private double calculateProductPerDay() {
        if (this.age >= 0 && this.age <= 5) {
            return 2.0;
        }
        if (this.age > 5 && this.age < 12) {
            return 1.0;
        }
        return 0.75;
    }
}
