package com.project.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTestConfig {

    private final Logger logger = LogManager.getLogger(AspectTestConfig.class);

    @Before("execution (* com.project.service.Impl.SimpleCalculatorImpl.addTwoNumber(..))")
    public void beforeRun(final JoinPoint joinPoint) {
        logger.info("Before: ClassName: {}", joinPoint.getTarget().getClass().getSimpleName());
        logger.info("Before: PackageName: {}", joinPoint.getThis().getClass().getName());
    }

    @Pointcut("execution (* com.project.service.Impl.SimpleCalculatorImpl.addTwoNumber(..))")
    public void pointCut(final JoinPoint joinPoint) {
        logger.info("PointCut: ClassName: {}", joinPoint.getTarget().getClass().getSimpleName());
        logger.info("PointCut: PackageName: {}", joinPoint.getThis().getClass().getName());
    }

}
