package Test;

import java.lang.management.MemoryUsage;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class SystemMemory {
    public static void main(String[] args) {

//        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
//        allStackTraces.forEach((k, v) -> {
//            System.out.println(k.toString() + " PROCESS: " + v.length);
//            Arrays.stream(v).forEach(System.out::println);
//            for (StackTraceElement vs : v) {
//                System.out.println(vs.toString());
//            }
//            System.out.println();
//        });


        System.out.println(new Date());
        Properties pr= System.getProperties();
      //  pr.list(System.out);
        System.out.println("--Memory Usage:");
        Runtime rt= Runtime.getRuntime();
        System.out.println("Total Memory= "+ rt.totalMemory() +" Free Memory: " + rt.freeMemory());
    }
}
