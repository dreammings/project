package com.jch.java.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
//这个类暂时不用，，目前通过继承GradeWebConfigAdapter，并重写addViewControllers方法控制页面跳转
//@RestController
//@RequestMapping("/")
public class HomePageRest {

    //主页面
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    //个人中心
    @RequestMapping("userinfo_page")
    public ModelAndView userInfo(){
        ModelAndView modelAndView = new ModelAndView("userinfo");
        return modelAndView;
    }
    //成绩录入
    @RequestMapping("scanner_page")
    public ModelAndView scanner(){
        ModelAndView modelAndView = new ModelAndView("scanner");
        return modelAndView;
    }

    //成绩列表
    @RequestMapping("show_page")
    public ModelAndView  getScoreListPage() {
        ModelAndView modelAndView = new ModelAndView("show");
        return modelAndView;
    }

    //成绩走势
    @RequestMapping("statistics_page")
    public ModelAndView statistics( ) {
        ModelAndView modelAndView = new ModelAndView("statistics");
        return modelAndView;
    }
//    @RequestMapping("/test")
//    public ModelAndView test(){
//        ModelAndView modelAndView = new ModelAndView("/test");
//        return modelAndView;
//    }
//
//    @RequestMapping("/tables")
//    public ModelAndView userinfo(){
//        ModelAndView modelAndView = new ModelAndView("/tables");
//        return modelAndView;
//    }
}
