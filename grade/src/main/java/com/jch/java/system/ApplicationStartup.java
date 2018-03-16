package com.jch.java.system;

import com.jch.java.system.httplog.listener.HttpLogListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/1/23.
 */
@Component
public class ApplicationStartup{
    @Autowired
    private HttpLogListener httpLogListener;
    //创建固定线程池
    private ExecutorService pool = Executors.newFixedThreadPool(1);

    @PostConstruct//该注解标记的方法，在服务启动成功后自动执行，且执行一次
    public void appStart(){
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    httpLog();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * 服务启动后监听日志队列
     */
    public void httpLog() throws InterruptedException {
        Thread.sleep(300);
        while (true) {
            httpLogListener.consumerMany();
        }
    }
}
