package com.csc3103.interceptor;

import javax.servlet.http.*;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        System.out.println("Request: " + request.getRequestURI());
        return true;
    }
}