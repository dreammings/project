package com.jch.java.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 描述：通过继承WebMvcConfigurerAdapter并重写其中部分方法达到自定义MVC配置的目的
 * Created by Administrator on 2018/1/24.
 */
@Configuration
public class GradeWebConfigAdapter extends WebMvcConfigurerAdapter {

    /**
     * 页面跳转控制：此种方式编码较为简洁
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //页面跳转较多时可根据模块封装方法提高代码的可读性
        registry.addViewController("index").setViewName("index");
        registry.addViewController("userinfo_page").setViewName("userinfo");
        registry.addViewController("scanner_page").setViewName("scanner");
        registry.addViewController("show_page").setViewName("show");
        registry.addViewController("statistics_page").setViewName("statistics");
//        registry.addViewController("index").setViewName("index");
//        registry.addViewController("index").setViewName("index");
//        registry.addViewController("index").setViewName("index");
        super.addViewControllers(registry);
    }
}
