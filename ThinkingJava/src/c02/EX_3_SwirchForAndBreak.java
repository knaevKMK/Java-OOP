package c02;

import java.util.Scanner;

public class EX_3_SwirchForAndBreak {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String result = null;
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    result = "Good Morning";
                    break;
                case 1:
                    result = "Good Afternoon";
                    break;
                case 2:
                    result = "Good Evening";
                    break;
            }
        }
        System.out.println(result);
    }
}
