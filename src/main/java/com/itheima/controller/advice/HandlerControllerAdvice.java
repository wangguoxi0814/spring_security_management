package com.itheima.controller.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理
 */
@ControllerAdvice
public class HandlerControllerAdvice {

    /**
     * 处理权限不足异常
     * @return
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    public String handlerAccessDeniedException() {
        return "redirect:/403.jsp";
    }

    /**
     * 处理其他异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String handlerRuntimeException() {
        return "redirect:/500.jsp";
    }
}
