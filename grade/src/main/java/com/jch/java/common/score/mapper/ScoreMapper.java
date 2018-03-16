package com.jch.java.common.score.mapper;

import com.jch.java.common.score.model.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    Integer selectByDate(String date);

    /**
     * 成绩列表：支持按考试日期、科目分数，正倒排序
     * @param type
     * @param start_time
     * @param end_time
     * @param sort
     * @param sequence
     * @param page
     * @param per_page
     * @return
     */
    List<Score> selectByParams(@Param("type")int type,@Param("start_time")String start_time, @Param("end_time")String end_time,
                               @Param("sort")String sort,@Param("sequence")int sequence,
                               @Param("page")int page,@Param("per_page")int per_page);

    /**
     * 成绩走势
     * @param type
     * @param start_time
     * @param end_time
     * @param subject
     * @return
     */
    List<Map> selectForStatistic(@Param("type")int type,@Param("start_time")String start_time, @Param("end_time")String end_time,@Param("subject")String subject);

    int selectTotal(@Param("type")int type,@Param("start_time")String start_time, @Param("end_time")String end_time);
}