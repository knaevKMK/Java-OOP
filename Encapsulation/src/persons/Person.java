package persons;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }


    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        checkLenght(firstName, "First name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        checkLenght(lastName, "Last name");
        this.lastName = lastName;
    }

    private void checkLenght(String name, String prefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " cannot be less than 3 symbols");
        }
    }

    public void setAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary<460){
            throw new IllegalArgumentException ("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " gets " + this.getSalary() + " leva";
        //String.format("%s %s gets %f leva.", this.getFirstName(), this.getLastName(), this.getSalary());
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            this.setSalary(this.getSalary() + this.getSalary() * bonus / 200);
        } else {
            this.setSalary(this.getSalary() + this.getSalary() * bonus / 100);
        }
    }
}
