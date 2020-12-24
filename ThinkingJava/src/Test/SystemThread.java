package Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Time;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Timer;

public class SystemThread {

    public static void main(String[] args) {

        System.out.println(new Time(System.currentTimeMillis()));
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
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
        System.out.println(new Time(System.currentTimeMillis()));
    }
}
