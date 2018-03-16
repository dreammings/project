package com.jch.java.system.thread;

import com.jch.java.config.thread.ThreadConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2018/1/9.
 */
@EnableAsync
@Component
public class TaskThreadPool {

    @Autowired
    private ThreadConfig threadConfig;

    @Bean("taskTheadExcutor")
    public Executor taskTheadExcutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadConfig.getCorePoolSize());
        executor.setMaxPoolSize(threadConfig.getMaxPoolSize());
        executor.setKeepAliveSeconds(threadConfig.getKeepAliveSeconds());
        executor.setQueueCapacity(threadConfig.getQueueCapacity());
        executor.setWaitForTasksToCompleteOnShutdown(threadConfig.isWaitForTasksToCompleteOnShutdown());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }

}
