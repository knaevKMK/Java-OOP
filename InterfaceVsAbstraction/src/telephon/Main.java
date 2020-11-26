package telephon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Smartphone smartphone = new Smartphone(Arrays.stream(scanner.readLine().split("\\s+")).collect(Collectors.toList())
                , Arrays.stream(scanner.readLine().split("\\s+")).collect(Collectors.toList()));

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
