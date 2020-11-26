package Vehicles;

import java.text.DecimalFormat;

public class DecFormat {


    public static String format(double s) {
        DecimalFormat dc = new DecimalFormat("#.##");
        return dc.format(s);
    }
}
