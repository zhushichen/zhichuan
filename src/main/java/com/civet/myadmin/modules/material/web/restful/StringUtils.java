package com.civet.myadmin.modules.material.web.restful;

public class StringUtils {
    public static boolean isBlank(String value){
       return null == value || "".equals(value);
    }

    public static boolean isNotBlank(String value){
        return !isBlank(value);
    }
}
