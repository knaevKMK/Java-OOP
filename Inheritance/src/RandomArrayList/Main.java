package RandomArrayList;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> list = new RandomArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        System.out.println(list.getRandomElement());
    }
}
