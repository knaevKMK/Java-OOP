package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Citizen> visitors = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();
        addVisitors(visitors,robots);

        String check = scanner.nextLine();
        printFakeId(check, visitors, robots);
    }

    private static void addVisitors(List<Citizen> visitors, List<Robot> robots) {
        String read;
        while (!"END".equalsIgnoreCase(read = scanner.nextLine())) {
            String[] token = read.split("\\s+");
            switch (token.length) {
                case 2:
                    robots.add(new Robot(token[0], token[1]));
                    break;
                case 3:
                    visitors.add(new Citizen(token[0], Integer.parseInt(token[1]), token[2]));
                    break;
            }
        }
    }


    private static void printFakeId(String check, List<Citizen> visitors, List<Robot> robots) {
        for (Citizen body : visitors) {
            if (body.getId().endsWith(check)) {
                System.out.println(body.getId());
            }
        }
        for (Robot robot : robots) {
            if (robot.getId().endsWith(check)) {
                System.out.println(robot.getId());
            }
        }
    }
}
