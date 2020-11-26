package problem1;

import java.awt.event.PaintEvent;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Buyer> list = new LinkedHashMap<>();
        String read;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            read = scanner.nextLine();
            //
            String[] token = read.split("\\s+");
            switch (token.length) {
                case 3:
                    list.put(token[0], new Rebel(token[0], Integer.parseInt(token[1]), token[2]));
                    break;
                case 4:
//                case "Citizen":
                    list.put(token[0], new Citizen(token[0], Integer.parseInt(token[1]), token[2], token[3]));
                    break;
//                case "Robot":
//                    //     list.add(new Robot(token[1], token[2]));
//                case "Pet":
//                    list.add(new Pet(token[1], token[2]));
            }


        }
        while (!"END".equalsIgnoreCase(read = scanner.nextLine())) {
            if (list.containsKey(read)) {
                list.get(read).buyFood();
            }

        }
        int result = list.values().stream()
                .mapToInt(Buyer::getFood).sum();
        System.out.println(result);

    }
}
