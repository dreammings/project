package com.jch.java.system.httplog;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2018/1/9.
 */
public interface LogProducer {

    /**
     * 队列初始化
     */
    public void init();

    /**
     * 获取队列
     * @return
     */
    public BlockingQueue<byte[]> getBlockingQueue();

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 队列是否已满
     * @return
     */
    public boolean isFull();

    /**
     * 队列生产者添加消息
     * @param object
     * @return
     */
    public boolean produce(Object object);

    /**
     * 队列消息添加失败处理
     * @param object
     * @return
     */
    public boolean addFail(Object object);
}
