package com.jch.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.ManagedBean;

@EnableAsync//此注解用于异步线程池调用
@SpringBootApplication
@ServletComponentScan//过滤器、拦截器、监听器注解
@EnableAutoConfiguration//配置类注解
@ManagedBean("com.jch.java.common.*.mapper")//加载mapper文件
public class GradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeApplication.class, args);
	}

}
