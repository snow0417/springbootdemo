package com.example.demo.service;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xueyu
 * @date 2020/9/2 15:48
 */
public class TestFactoryBean implements FactoryBean<Test> {


    @Override
    public Test getObject() throws Exception {
        return new Test();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
