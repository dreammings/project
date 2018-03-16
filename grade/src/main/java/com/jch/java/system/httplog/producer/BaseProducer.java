package com.jch.java.system.httplog.producer;

import com.jch.java.system.httplog.LogProducer;

/**
 * Created by Administrator on 2018/1/10.
 */
public abstract class BaseProducer implements LogProducer{

    /**
     * 队列长度限制
     */
    protected static final int QUEUELIMIT = 10240;

    /**
     * 队列异常时，报警处理
     */
    protected abstract void alarmMsg();
}
