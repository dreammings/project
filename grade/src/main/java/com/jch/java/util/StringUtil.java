package com.jch.java.util;

public class StringUtil {

    /**
     * 字符串是否为空
     * @param str
     * @return NULL、""、"null"均返回true，其他返回false
     */
    public static boolean isNull(String str){
        if(str==null || str.equals("") || str.equals("null")){
            return true;
        }
        return false;
    }
}
