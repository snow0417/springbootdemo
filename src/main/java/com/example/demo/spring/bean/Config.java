package com.example.demo.spring.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xueyu
 * @date 2020/9/3 10:54
 */
@Configuration
@Import(TestBeanDefinitionRegistry.class)
public class Config {

//    @Bean
//    public TestBeanFactory testBeanFactory(){
//        return new TestBeanFactory();
//    }

//    @Bean
//    public TestBeanDefinitionRegistry testBeanDefinitionRegistry(){
//        return new TestBeanDefinitionRegistry();
//    }
}
