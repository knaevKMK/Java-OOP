package MilitaryElite;

import MilitaryElite.Entities.*;
import MilitaryElite.Entities.Utilities.Mission;
import MilitaryElite.Entities.Utilities.Repair;
import MilitaryElite.Enums.State;
import MilitaryElite.Interfaces.ISoldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<String, Private> soldiers = new LinkedHashMap<>();
        String read;
        while (!"END".equalsIgnoreCase(read = scanner.readLine())) {
            String[] token = read.split("\\s+");
            String id = token[1];
            switch (token[0]) {
                case "Private":
                    Private soldier = new Private(token);
                    printResult(soldier);
                    soldiers.put(id, soldier);
                    break;
                case "Commando":
                    if (!token[5].equalsIgnoreCase("AIRFORCES") && !token[5].equalsIgnoreCase("MARINES")) {
                        continue;
                    }
                    Commando commando = new Commando(token);
                    addMissions(commando, token);
                    printResult(commando);
                    break;
                case "Engineer":
                    if (!token[5].equalsIgnoreCase("AIRFORCES") && !token[5].equalsIgnoreCase("MARINES")) {
                        continue;
                    }
                    Engineer engineer = new Engineer(token);
                    addRepairs(engineer, token);
                    printResult(engineer);
                    break;
                case "LeutenantGeneral":
                    LeutenantGeneral lim = new LeutenantGeneral(token);
                    getIdList(token, soldiers, lim);
                    printResult(lim);
                    break;
                case "Spy":
                    printResult(new Spy(read.split("\\s+")));
                    break;
                default:
                    break;
            }
        }
    }

    private static void addRepairs(Engineer engineer, String[] token) {
        for (int i = 6; i < token.length; i += 2) {
            engineer.addRepair(new Repair(token[i], Integer.parseInt(token[i + 1])));
        }
    }

    private static void addMissions(Commando commando, String[] token) {
        for (int i = 6; i < token.length; i += 2) {
            if (token[i + 1].equals("inProgress") || token[i + 1].equals("Finished")) {
                commando.addMission(new Mission(token[i], State.valueOf(token[i + 1].toUpperCase())));
            }
        }
    }

    private static void printResult(ISoldier s) {
        System.out.println(s);
    }

    private static void getIdList(String[] token, Map<String, Private> soldiers, LeutenantGeneral lim) {

        for (int i = 5; i < token.length; i++) {
            String id = token[i];
            if (soldiers.containsKey(id)) {
                lim.addPrivate(soldiers.get(id));
            }
        }
    }
}
