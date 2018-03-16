package com.jch.java.config.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/1/9.
 */
@Configuration
public class ThreadConfig {

    @Value("${thread.corePoolSize}")
    private String corePoolSize;

    @Value("${thread.maxPoolSize}")
    private String maxPoolSize;

    @Value("${thread.keepAliveSeconds}")
    private String keepAliveSeconds;

    @Value("${thread.queueCapacity}")
    private String queueCapacity;

    @Value("${thread.WaitForTasksToCompleteOnShutdown}")
    private String WaitForTasksToCompleteOnShutdown;

    public int getCorePoolSize() {
        return Integer.parseInt(corePoolSize);
    }

    public void setCorePoolSize(String corePoolSize) {

        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {

        return Integer.parseInt(maxPoolSize);
    }

    public void setMaxPoolSize(String maxPoolSize) {

        this.maxPoolSize = maxPoolSize;
    }

    public int getKeepAliveSeconds() {

        return Integer.parseInt(keepAliveSeconds);
    }

    public void setKeepAliveSeconds(String keepAliveSeconds) {

        this.keepAliveSeconds = keepAliveSeconds;
    }

    public int getQueueCapacity() {
        return Integer.parseInt(queueCapacity);
    }

    public void setQueueCapacity(String queueCapacity) {

        this.queueCapacity = queueCapacity;
    }

    public boolean isWaitForTasksToCompleteOnShutdown() {
        return Boolean.parseBoolean(WaitForTasksToCompleteOnShutdown);
    }

    public void setWaitForTasksToCompleteOnShutdown(String waitForTasksToCompleteOnShutdown) {
        this.WaitForTasksToCompleteOnShutdown = waitForTasksToCompleteOnShutdown;
    }
}
