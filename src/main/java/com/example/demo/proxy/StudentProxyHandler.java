package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xueyu
 * @date 2020/6/16 15:18
 */
public class StudentProxyHandler implements InvocationHandler {
    private IStudent student;
    public StudentProxyHandler(IStudent student){
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start ....");
        System.out.println(proxy.getClass().getName());
        Class[] inter = proxy.getClass().getInterfaces();
        student.study();
        System.out.println("end....");
        return null;
    }
}
