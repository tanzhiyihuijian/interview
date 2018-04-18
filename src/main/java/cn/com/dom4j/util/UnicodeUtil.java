package cn.com.dom4j.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeUtil {

    public static void main(String[] args) {

        System.out.println(UnicodeToString("\\u5317\\u4eac\\u5e02"));

    }

    public static String UnicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }


}
