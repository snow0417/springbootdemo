package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xueyu
 * @date 2020/9/2 16:17
 */
@Configuration
public class BeanConfig {

    @Bean
    public Test test(){
        return new Test();
    }
}
