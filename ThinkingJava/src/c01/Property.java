package c01;

import java.util.Date;
import java.util.Properties;

public class Property {
    /*
     * Sole entry point to class & application
     * @param args array of string arguments
     * @return No return value
     * @throws exceptions No exceptions thrown
     */

    public static void main(String[] args) {
        System.out.println(new Date());
        Properties p = System.getProperties();
        p.list(System.out);
        System.out.println("--- Memory Usage:");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory = " + rt.totalMemory() + " Free Memory = " + rt.freeMemory());
    }
}

