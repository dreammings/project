package com.jch.java.common.score.model;

import java.util.Date;

public class Score {
    private Integer id;

    private Byte type;

    private Integer chinese;

    private Integer maths;

    private Integer english;

    private Integer politics;

    private Integer history;

    private Integer geography;

    private Integer synthesize;

    private Integer total_points;

    private Date date;

    private Date create_time;

    private Date update_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getPolitics() {
        return politics;
    }

    public void setPolitics(Integer politics) {
        this.politics = politics;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }

    public Integer getGeography() {
        return geography;
    }

    public void setGeography(Integer geography) {
        this.geography = geography;
    }

    public Integer getSynthesize() {
        return synthesize;
    }

    public void setSynthesize(Integer synthesize) {
        this.synthesize = synthesize;
    }

    public Integer getTotal_points() {
        return total_points;
    }

    public void setTotal_points(Integer total_points) {
        this.total_points = total_points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}