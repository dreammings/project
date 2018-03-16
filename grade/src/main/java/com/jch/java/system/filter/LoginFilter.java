package com.jch.java.system.filter;

import com.jch.java.system.ResponseWrapper;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/24.
 */
@WebFilter(urlPatterns="/*", filterName = "requestFilter")
//@Order(1)//多个过滤器时，定义过滤器的执行顺序
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("启动过滤器");
    }

    /**
     * 授权登录过滤：未登录则直接跳转登录页面，登录后将用户数据放进session
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        ResponseWrapper responseWrapper = new ResponseWrapper(httpServletResponse);
        HttpSession session = httpServletRequest.getSession();
        String requestURI = httpServletRequest.getRequestURI();
        //当加载的静态资源过大时，经过ResponseWrapper代理类处理过的response会导致浏览器报错（ERR_CONTENT_LENGTH_MISMATCH）
        //而我们只想处理请求接口返回的数据，所以此处判断：请求接口则使用ResponseWrapper代理类，否则维持原样
        if(requestURI.contains(".")){
            //静态资源
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //数据接口
            filterChain.doFilter(servletRequest,responseWrapper);
        }
        //登录过滤
        if(!requestURI.contains("login")){
            Object member = session.getAttribute("member");
            if (member == null){
                httpServletResponse.sendRedirect("/login");
                return ;
            }
        }
        //登录后将用户信息放进session
        if(requestURI.contains("login")){
            byte[] content = responseWrapper.getContent();
            if (content.length>0){
                String result = new String(content,"UTF-8");
                session.setAttribute("member", result);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
