package com.example.demo.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xueyu
 * @date 2020/9/3 11:11
 */
public class TestBeanFactory implements FactoryBean<TestBean> {


    @Override
    public TestBean getObject() throws Exception {
        return new TestBean();
    }

    @Override
    public Class<?> getObjectType() {
        return TestBean.class;
    }
}
