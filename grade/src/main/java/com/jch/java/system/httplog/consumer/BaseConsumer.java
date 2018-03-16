package com.jch.java.system.httplog.consumer;

import com.jch.java.system.httplog.LogConsumer;

/**
 * Created by Administrator on 2018/1/11.
 */
public abstract class BaseConsumer implements LogConsumer{

    /**
     * 批量处理的消息数量
     */
    public static final int BATCHLIMIT = 10;

}
