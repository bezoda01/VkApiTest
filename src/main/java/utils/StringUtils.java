package utils;

import java.util.Random;

public class StringUtils {
    public static String randomText() {
        Random r = new Random();
        int length = 20;
        StringBuffer sb = new StringBuffer();
        while (sb.length() < length) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, length);
    }
    public static String splitString(String str, String delimenter) {
        String[] temp = str.split(delimenter);
        return temp[0];
    }
}
