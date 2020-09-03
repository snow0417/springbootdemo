package com.example.demo.service;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author xueyu
 * @date 2020/9/2 15:49
 */
public class Test implements InitializingBean {
    private TestService testService;

    public void setTest(TestService testService){
        this.testService = testService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
