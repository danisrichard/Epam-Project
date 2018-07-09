package com.project.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestResponseLogging implements HandlerInterceptor {

    private static final Logger logger = LogManager.getLogger(RequestResponseLogging.class);

    private Long postTimeInMs;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        postTimeInMs = System.currentTimeMillis();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        try {
            logger.info("request method name: {}, response method name: {} , response time: {} ms",
                    ((HandlerMethod) handler).getMethod().getName(), request.getRequestURI(), System.currentTimeMillis() - postTimeInMs);
        }catch (NullPointerException e){
            logger.info(e.getMessage());
        }
    }
}
