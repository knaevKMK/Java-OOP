package Test;

public class Random {
    public static void main(String[] args) {
        java.util.Random rand = new java.util.Random();
        int i = rand.nextInt() % 100;
        int j = rand.nextInt() % 100;
        prt("i = " + i);
        prt("j = " + j);
        prt("i > j is " + (i > j));
        prt("i < j is " + (i < j));
        prt("i >= j is " + (i >= j));
        prt("i <= j is " + (i <= j));
        prt("i == j is " + (i == j));
        prt("i != j is " + (i != j));
        prt("(i < 10) && (j < 10) is " + ((i < j) && (j < i)));
        prt("(i < 10) || (j < 10) is " + ((i < j) || (j < i)));
    }

    private static void prt(String s) {
        System.out.println(s);
    }
}
