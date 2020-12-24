package Test;

public class Operators {
    public static void main(String[] args) {
        int n = 1;
        System.out.printf("%d %d %d %d %d %d%n", n++, n, ++n, n--, n, --n);


        for (int i = 0, j = i + 10; i < 5;
             i++, j = i * 2) {
            System.out.println("i= " + i + " j= " + j);
        }

    }
}
