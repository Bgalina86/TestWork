package calculator.helper;

public class StringSplitting {

    public static String splittingString(String s) {
        if (null != s) {
            if (!s.isEmpty()) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
