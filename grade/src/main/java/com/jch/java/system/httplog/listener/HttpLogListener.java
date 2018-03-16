package com.jch.java.system.httplog.listener;

import com.jch.java.system.httplog.consumer.HttpLogConsumer;
import com.jch.java.system.httplog.producer.HttpLogProducer;
import com.jch.java.util.SerializeUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/19.
 */
@Component
public class HttpLogListener extends BaseListener{

    public HttpLogListener(){
        if (this.logProducer == null){
            this.logProducer = new HttpLogProducer();
        }
        if (this.logConsumer == null){
            this.logConsumer = new HttpLogConsumer();
        }
    }

    /**
     * 队列批量消费
     */
    @Async("taskTheadExcutor")
    @Override
    public void consumerMany(){
        Collection collection = new ArrayList<byte[]>();
        int num = logProducer.getBlockingQueue().drainTo(collection, HttpLogConsumer.BATCHLIMIT);
        if (num > 0){
            Iterator<byte[]> iterator = collection.iterator();
            while (iterator.hasNext()){
                byte[] bytes = iterator.next();
                Map<String, Object> map = (Map<String, Object>) SerializeUtil.unserialize( bytes );
                try {
                    logConsumer.consumer(map);
//                    Thread.sleep(1500);
                } catch (Exception e) {
                    e.printStackTrace();
                    //失败处理
                    logConsumer.dealFail(map);
                }
            }
        }
    }
}
