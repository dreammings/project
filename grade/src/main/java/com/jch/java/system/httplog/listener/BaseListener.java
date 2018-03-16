package com.jch.java.system.httplog.listener;

import com.jch.java.system.httplog.LogConsumer;
import com.jch.java.system.httplog.LogProducer;

/**
 * Created by Administrator on 2018/1/10.
 */
public abstract class BaseListener {

    /**
     * 队列消费者
     */
    protected LogConsumer logConsumer = null;

    /**
     * 队列生产者
     */
    protected LogProducer logProducer = null;

    /**
     * 队列批量消费
     */
    protected abstract void consumerMany();
}
