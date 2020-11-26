package FootballTeamGenerator;

import java.util.Map;

public class Validation {
    private Validation() {
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validateInt(int value, String prefix) {
       if (value<0|| value>100){
           throw  new IllegalArgumentException(prefix+ " should be between 0 and 100.");
       }
    }

    public static void teamExist(Map<String, Team> teams, String s) {
        if (!teams.containsKey(s)){
            throw new IllegalArgumentException("Team "+ s+" does not exist.");
        }
    }
}
