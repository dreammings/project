package com.jch.java.common.score.service;

public interface ScoreService {

    /**
     * 成绩录入（根据日期排重）
     * @param type
     * @param time
     * @param chinese
     * @param maths
     * @param english
     * @param politics
     * @param history
     * @param geography
     * @return 成功返回ID，失败返回0,已存在返回-1
     */
    public int addScore(int type, String time, int chinese, int maths, int english, int politics, int history, int geography);

    /**
     * 成绩列表
     * @param type
     * @param sort
     * @param start_time
     * @param end_time
     * @param sequence
     * @param page
     * @param per_page
     * @return
     */
    public String getScoreList(int type, String sort, String start_time,String end_time, int sequence, int page, int per_page);

    /**
     * 成绩走势图
     * @param type
     * @param subject
     * @param start_time
     * @param end_time
     * @return
     */
    public String getScoreReport(int type, String subject,String start_time,String end_time);
}
