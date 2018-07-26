package com.project.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws NullPointerException {
        try {
            logger.info(" response method name: {} , response time: {} ms",
                    request.getRequestURI(), System.currentTimeMillis() - postTimeInMs);
        }catch (NullPointerException e){
            logger.info("Problem : " + e.fillInStackTrace());
        }
    }
}
