package com.example.demo.mybatis.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author xueyu
 * @date 2020/6/30 18:44
 */
@Aspect
@Component
public class DataSourceAop {
    @Pointcut("@annotation(com.example.demo.mybatis.config.DS)")
    public void dsPointcut() {

    }

    @Around("dsPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        DS ds = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod().getAnnotation(DS.class);
        try {
            if (ds.value().equals("master")) {
                DbContextHolder.master();
            } else if (ds.value().equals("slave")) {
                DbContextHolder.slave();
            }
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;


    }
}
