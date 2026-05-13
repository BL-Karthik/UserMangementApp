package org.gevernova.SpringCurdDemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAop {
    private final Logger log= LoggerFactory.getLogger(UserAop.class);

    @Before("execution(* org.gevernova.SpringCurdDemo.controller.UserController.*(..))")
    public void userController(JoinPoint joinPoint)
    {
        log.info("method started : "+joinPoint.getSignature().getName());
    }

    @After("execution(* org.gevernova.SpringCurdDemo.controller.*.*(..))")
    public void afterMethod()
    {
       log.info("method ended");
    }

    @Around("execution(* org.gevernova.SpringCurdDemo.*.*.*(..)))")
    public Object beforeAndAfterMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("method before started with around");
        Object result=proceedingJoinPoint.proceed();
        log.info("method started with around");
        return result;
    }

    // after returning  , after throwing
}
