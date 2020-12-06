import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandAsArray = command.split(" : ");
            String courseName = commandAsArray[0];
            String studentName = commandAsArray[1];
            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            } else {
                if (!courses.get(courseName).contains(studentName)) {
                    courses.get(courseName).add(studentName);
                }
            }


            command = scanner.nextLine();

        }
        courses.entrySet().stream().sorted((a, b) -> Integer.compare(a.getValue().size(), b.getValue().size())).
                forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue());//System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size()); // тук принтираме в ред на добавяне, затова не е ннужно друго
                    e.getValue().stream().sorted((a, b) -> a.compareTo(b)) // тук стриймваме всичките елементи от value на САМО ЕДНО entry и ги подреждаме в възходящ АЗБУЧЕН ред.
                            .forEach(element -> System.out.printf("-- %s%n", element));
                }); // тук принтираме.


    }
}