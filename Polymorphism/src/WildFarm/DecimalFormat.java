package WildFarm;

public class DecimalFormat {
    private DecimalFormat() {
    }

    public static String format(Double s) {
        java.text.DecimalFormat dc = new java.text.DecimalFormat("#.##");
        return dc.format(s);
    }

}
