package FootballTeamGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teams = new LinkedHashMap<>();

        String read;
        while (!"END".equals(read = scanner.nextLine())) {
            String[] token = read.split(";");

            try {

                switch (token[0]) {
                    case "Team":
                        teams.put(token[1], new Team(token[1]));
                        break;
                    case "Add":
                        Validation.teamExist(teams, token[1]);
                        String name = token[2];
                        int endurance = Integer.parseInt(token[3]);
                        int sprint = Integer.parseInt(token[4]);
                        int dribble = Integer.parseInt(token[5]);
                        int passing = Integer.parseInt(token[6]);
                        int shooting = Integer.parseInt(token[7]);
                        teams.get(token[1]).addPlayer(new Player(name, endurance, sprint, dribble, passing, shooting));
                        break;
                    case "Remove":
                        Validation.teamExist(teams, token[1]);
                        teams.get(token[1]).removePlayer(token[2]);
                        break;
                    case "Rating":
                        Validation.teamExist(teams, token[1]);
                        System.out.printf("%s - %.0f%n", token[1], teams.get(token[1]).getRating());

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
