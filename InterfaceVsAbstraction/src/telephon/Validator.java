package telephon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Validator() {

    }

    public static String checkNumbers(String s) {
        if (Pattern.compile("[^\\d]").matcher(s).find()) {
            return "Invalid number!";
        }
        return "Calling... " + s;
    }


    public static String checkUrls(String s) {
        if (Pattern.compile("\\d").matcher(s).find()) {
            return "Invalid URL!";
        }
        return "Browsing: " + s;

    }
}
