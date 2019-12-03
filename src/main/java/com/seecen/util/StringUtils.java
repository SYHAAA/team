package com.seecen.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String parseDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(date != null) return sdf.format(date);
        return null;
    }

}
