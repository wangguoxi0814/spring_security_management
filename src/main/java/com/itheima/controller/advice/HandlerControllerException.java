package com.itheima.controller.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HandlerControllerException implements HandlerExceptionResolver {

    /**
     * 解析异常，根据不同异常，跳转到不同错误提示页面
     * @param httpServletRequest   请求
     * @param httpServletResponse  响应
     * @param o                    出现异常的对象
     * @param e                    出现的异常信息
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", e.getMessage());
        if (e instanceof AccessDeniedException) {
            // 这里加redirect表示重定向，浏览器地址发生变化,如果是forward，地址不会变化。
            // 如果直接是403.jsp，会经过视图解析器，会跳转到/pages/403.jsp.jsp，见spring-mvc.xml中视图解析器配置，会给视图名称加上前缀和后缀
            modelAndView.setViewName("redirect:/403.jsp");
        } else {
            modelAndView.setViewName("redirect:/500.jsp");
        }
        return modelAndView;
    }
}
