package com.jch.java.system.httplog.consumer;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/11.
 */
public class HttpLogConsumer extends BaseConsumer {

    /**
     * 队列消费
     * @param map
     * @return
     */
    @Override
    public boolean consumer(Map<String, Object> map) {
        System.out.println(Thread.currentThread().getName()+":"+map.toString()+"消费成功了");
        return false;
    }

    /**
     * 消费失败处理
     * @param map
     * @return
     */
    @Override
    public boolean dealFail(Map<String, Object> map) {
        return false;
    }
}
