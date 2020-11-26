package animal;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    protected String produceSound() {
        return "";
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(getClass().getSimpleName()).append(System.lineSeparator());
        print.append(this.getName()).append(" ").append(this.getAge()).append(" ")
                .append(this.getGender()).append(System.lineSeparator())
                .append(this.produceSound());
        return print.toString();
    }
}
