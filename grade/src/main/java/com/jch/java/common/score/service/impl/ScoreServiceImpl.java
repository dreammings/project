package com.jch.java.common.score.service.impl;

import com.jch.java.common.score.mapper.ScoreMapper;
import com.jch.java.common.score.model.Score;
import com.jch.java.common.score.service.ScoreService;
import com.jch.java.util.DateUtil;
import com.jch.java.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public int addScore(int type, String time, int chinese, int maths, int english, int politics, int history, int geography) {
        Integer id = scoreMapper.selectByDate(time);
        if (id !=null && id>0){
            return -1;
        }
        Score score = new Score();
        score.setType((byte) type);
        score.setDate(DateUtil.stringToDate(time));
        score.setChinese(chinese);
        score.setMaths(maths);
        score.setEnglish(english);
        score.setPolitics(politics);
        score.setHistory(history);
        score.setGeography(geography);
        score.setSynthesize(politics + history + geography);
        score.setTotal_points(chinese + maths + english + score.getSynthesize());
        score.setCreate_time(DateUtil.Tymdhms());
        score.setUpdate_time(DateUtil.Tymdhms());
        int result = scoreMapper.insert(score);
        return score.getId();
    }

    @Override
    public String getScoreList(int type, String sort, String start_time, String end_time, int sequence, int page, int per_page) {
        if(page==0){
            page=1;
        }
        if(per_page==0){
            per_page=10;
        }
        page = (page-1)*per_page;
        int total = scoreMapper.selectTotal(type, start_time, end_time);
        List<Score> scoreList = scoreMapper.selectByParams(type, start_time, end_time, sort, sequence, page, per_page);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("list", JsonUtil.toJSON(scoreList));
        return json.toString();
    }

    @Override
    public String getScoreReport(int type, String subject, String start_time, String end_time) {
        List<Map> statisticList = scoreMapper.selectForStatistic(type, start_time, end_time, subject);
        //日期
        List<String> dateList = new ArrayList<>();
        //分数
        List<Integer> subjectList = new ArrayList<>();
        for (Map statist : statisticList){
            dateList.add(statist.get("date").toString());
            subjectList.add((Integer) statist.get(subject));
        }
        Map<String,Object> json = new HashMap<>();
        json.put("date", dateList);
        json.put("subject", subjectList);
        return JsonUtil.toJSON(json);
    }


}
