package com.jch.java.api;

import com.jch.java.common.score.service.ScoreService;
import com.jch.java.util.Constant;
import com.jch.java.util.Response;
import com.jch.java.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    //成绩添加
    @RequestMapping("insert")
    public String addScore(@RequestParam("type") int type, @RequestParam("time") String time,
                             @RequestParam("chinese") int chinese, @RequestParam("maths") int maths,
                             @RequestParam("english") int english, @RequestParam("politics") int politics,
                             @RequestParam("history") int history, @RequestParam("geography") int geography) {
        if(StringUtil.isNull(time)){
            return Response.info().setCode(Constant.ADD_SCORE_CODE).setMsg(Constant.ADD_SCORE_TIME_MSG).setData(Constant.FAIL_DATA).toJSON();
        }
        try {
            int id = scoreService.addScore(type, time, chinese, maths, english, politics, history, geography);
            switch (id){
                case -1:
                    return Response.info().setCode(Constant.ADD_SCORE_CODE).setMsg(Constant.ADD_SCORE_EXIST_MSG).setData(Constant.FAIL_DATA).toJSON();
                default:
                    return Response.info().setCode(Constant.SUCCESS_CODE).setMsg(Constant.ADD_SCORE_SUCCESS_MSG).setData(id).toJSON();
            }
        }catch (Exception e) {
            e.printStackTrace();
            return Response.info().setCode(Constant.ADD_SCORE_CODE).setMsg(Constant.ADD_SCORE_FAIL_MSG).setData(Constant.FAIL_DATA).toJSON();
        }
    }

    //成绩列表
    @RequestMapping("show")
    public String  getScoreList(@RequestParam(defaultValue = "0") int type, String sort,
                                String start_time,String end_time,@RequestParam(defaultValue = "2") int sequence,
                                @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int per_page) {
        try{
            String scoreList = scoreService.getScoreList(type, sort, start_time, end_time, sequence, page, per_page);
            return Response.info().setCode(Constant.SUCCESS_CODE).setMsg(Constant.QUERY_SCORE_LIST_SUCCESS_MSG).setData(scoreList).toJSON();
        }catch (Exception e){
            e.printStackTrace();
            return Response.info().setCode(Constant.QUERY_SCORE_LIST_CODE).setMsg(Constant.QUERY_SCORE_LIST_FAIL_MSG).setData(Constant.FAIL_DATA).toJSON();
        }
    }

    //成绩走势
    @RequestMapping("statistics")
    public String getScoreReport(@RequestParam(defaultValue = "0") int type, @RequestParam("subject") String subject,String start_time,String end_time){
        try{
            String statistic = scoreService.getScoreReport(type, subject, start_time, end_time);
            return Response.info().setCode(Constant.SUCCESS_CODE).setMsg(Constant.QUERY_STATISTICS_SUCCESS_MSG).setData(statistic).toJSON();
        }catch (Exception e){
            e.printStackTrace();
            return Response.info().setCode(Constant.QUERY_STATISTICS_CODE).setMsg(Constant.QUERY_STATISTICS_FAIL_MSG).setData(Constant.FAIL_DATA).toJSON();
        }
    }

}
