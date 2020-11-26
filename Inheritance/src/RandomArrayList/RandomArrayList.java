package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {
    private Random random;

    public RandomArrayList() {
        this.random = new Random();
    }

    private int getRandom() {
        return random.nextInt(super.size());
    }

    public E getRandomElement() {
        return super.remove(getRandom());
    }

}
