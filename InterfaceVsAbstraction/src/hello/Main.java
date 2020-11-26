package hello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BasePerson> persons = new ArrayList<>();


        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));

        for (BasePerson person : persons) {
            print(person);
        }
    }

    private static void print(BasePerson person) {
        System.out.println(person.sayHello());
    }

}
