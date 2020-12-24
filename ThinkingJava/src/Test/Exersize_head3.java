package Test;

public class Exersize_head3 {

    public static void main(String[] args) {
        getcount(1);
    }
    private static void getcount(int i) {
        System.out.println(i++);
        if (i <= 100) {
            getcount(i);
        }
        System.runFinalization();
    }

}
