package com.jch.java.util;

public class Constant {

    //成功
    public final static int SUCCESS_CODE = 200;
    public final static String SUCCESS_DATA="success";

    //失败
    public final static String FAIL_DATA="fail";

    //成绩录入
    public final static int ADD_SCORE_CODE=1001;
    public final static String ADD_SCORE_SUCCESS_MSG="录入成功！";
    public final static String ADD_SCORE_FAIL_MSG="录入失败！";
    public final static String ADD_SCORE_TIME_MSG="请输入考试日期！";
    public final static String ADD_SCORE_EXIST_MSG="这一天的考试成绩已经添加了，请勿重新添加！";

    //成绩列表
    public final static int QUERY_SCORE_LIST_CODE=1002;
    public final static String QUERY_SCORE_LIST_SUCCESS_MSG="查询成功！";
    public final static String QUERY_SCORE_LIST_FAIL_MSG="查询失败！";

    //成绩走势图
    public final static int QUERY_STATISTICS_CODE=1003;
    public final static String QUERY_STATISTICS_SUCCESS_MSG="查询成功！";
    public final static String QUERY_STATISTICS_FAIL_MSG="查询失败！";

}
