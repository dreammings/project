package com.jch.java.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class JsonUtil {

    private static ObjectMapper mapper;

    /**
     * Object可以是POJO，也可以是Collection或数组�?
     * 如果对象为Null, 返回"null".
     * 如果集合为空集合, 返回"[]".
     */
    public static String toJSON(Object object) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper = new ObjectMapper();
        try {
            mapper.setDateFormat(dateFormat);
            return mapper.writeValueAsString(object);

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }


    }
}
