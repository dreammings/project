package com.jch.java.system.httplog;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/9.
 */
public interface LogConsumer {

    /**
     * 队列消费者消费
     * @param map
     * @return
     */
    public boolean consumer(Map<String, Object> map);

    /**
     * 队列消费失败处理
     * @param map
     * @return
     */
    public boolean dealFail(Map<String, Object> map);
}
