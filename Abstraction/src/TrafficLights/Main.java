package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        List<TrafickLight> trafickLights = new ArrayList<>();
        for (String s : line) {
            trafickLights.add(new TrafickLight(Light.valueOf(s)));
        }
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            for (TrafickLight trafickLight : trafickLights) {
                trafickLight.update();
                System.out.print(trafickLight.getLight() + " ");
            }
            System.out.println();
        }
    }
}
