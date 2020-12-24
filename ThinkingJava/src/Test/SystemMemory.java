package Test;

import java.util.Arrays;
import java.util.Map;

public class SystemMemory {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        allStackTraces.forEach((k, v) -> {
            System.out.println(k.toString() + " PROCESS: "+ v.length);
            Arrays.stream(v).forEach(System.out::println);
            for (StackTraceElement vs : v) {
                System.out.println(vs.toString());
            }
            System.out.println();
        });
    }
}
