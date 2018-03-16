package com.jch.java.system.httplog.producer;

import com.jch.java.util.SerializeUtil;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/1/11.
 */
public class HttpLogProducer extends BaseProducer {

    /**
     * 报警限制
     */
    private static volatile AtomicInteger ALARMLIMIT = new AtomicInteger(3);

    private static volatile BlockingQueue<byte[]> blockingQueue = null;

    @Override
    public BlockingQueue<byte[]> getBlockingQueue() {
        return blockingQueue;
    }

    /**
     * 构造方法：初始化blockingQueue
     */
    public HttpLogProducer() {
        if( blockingQueue == null ){
            this.init();
        }
    }

    //队列初始化
    @Override
    public synchronized void init() {
        if( blockingQueue == null ){
            blockingQueue = new LinkedBlockingQueue<byte[]>( QUEUELIMIT );
        }
    }

    //队列是否为空
    @Override
    public boolean isEmpty() {
        return blockingQueue.isEmpty();
    }

    //队列是否已满
    @Override
    public boolean isFull() {
        //remainingCapacity方法返回可立即添加元素的数量（可接受且不会被阻塞）
        return blockingQueue.remainingCapacity()>0 ? false : true;
    }

    //添加消息
    @Override
    public boolean produce(Object object) {
        if (object == null){
            return false;
        }
        Map<String,Object> map = (Map<String, Object>) object;
        boolean offer = blockingQueue.offer(SerializeUtil.serialize(map));
        if (!offer){
            System.out.println(Thread.currentThread().getName()+":"+object.toString()+"添加队列失败了");
            addFail(object);
            //失败次数超过三次时。触发报警方法
            if (ALARMLIMIT.decrementAndGet()<=0){
                this.alarmMsg();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+":"+object.toString()+"添加队列成功了");
        }
        return offer;
    }

    //消息添加失败处理
    @Override
    public boolean addFail(Object object) {
        return false;
    }

    //报警处理
    @Override
    protected void alarmMsg() {

    }

//    public static void main(String[] args) {
//        AtomicInteger ALARMLIMIT = new AtomicInteger(3);
//        System.out.println(ALARMLIMIT.decrementAndGet());
//    }
}
