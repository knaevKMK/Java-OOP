package c12;

import java.util.Arrays;

public class Battery {
    int number;

    public Battery(int idNum) {
        this.number = idNum;
    }

    public Battery clone() {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    static class Toy {
        Battery[] batteries;

        public Toy() {
            this.batteries = new Battery[6];
        }

        public Toy clone() {
            return this;
        }

        @Override
        public String toString() {
            return Arrays.toString(batteries);
        }

    }

    public static void main(String[] args) {
        Toy toy = new Toy();
        Battery battery = new Battery(333);
        Battery primeBatery = battery.clone();
        Toy primeToy = toy.clone();
    }
}
