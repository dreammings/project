package com.jch.java.util;

import net.sf.json.JSONObject;

public class Response {

    private static int code = 0;

    private static String msg = "";

    private Object data;

    public static Response info() {
        return new Response();
    }

    public static int getCode() {
        return code;
    }

    public  Response setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }
    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",this.code);
        jsonObject.put("msg",this.msg);
        jsonObject.put("data",this.data);
        return jsonObject.toString();
    }
}
