package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray());
        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            game.setEvil(scanner.nextInt(), scanner.nextInt());
            scanner.nextLine();
            int playerRow = Integer.parseInt(command.split("\\s+")[0]);
            int playerCol = Integer.parseInt(command.split("\\s+")[1]);
            game.play(playerRow, playerCol);
            command = scanner.nextLine();
        }
        System.out.println(game.getPlayer());
    }
}
