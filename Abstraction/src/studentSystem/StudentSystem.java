package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo = new HashMap<>();

    public Map<String, Student> getRepo() {
        return repo;
    }

    public void create(String... args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        if (!repo.containsKey(name)) {
            repo.put(name, new Student(name, age, grade));
        }
    }

    public String show(String name) {
        if (repo.containsKey(name)) {
            Student student = repo.get(name);
            return student.toString() + getComment(student.getGrade()) + System.lineSeparator();
        }
        return "";
    }

    private String getComment(double grade) {
        if (grade >= 5.00) {
            return " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return " Average student.";
        } else {
            return " Very nice person.";
        }

    }
}
