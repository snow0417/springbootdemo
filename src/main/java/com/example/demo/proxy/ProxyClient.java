package com.example.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * @author xueyu
 * @date 2020/6/16 15:22
 */
public class ProxyClient {

    public static void main(String[] args) {
        IStudent student = new Student();
        StudentProxyHandler handler = new StudentProxyHandler(student);
        IStudent s = (IStudent) Proxy.newProxyInstance(Student.class.getClassLoader(), Student.class.getInterfaces(), handler);
        s.study();
    }
}
