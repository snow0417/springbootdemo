package com.example.demo.spring.bean;

import com.example.demo.service.TestService;
import lombok.Data;

/**
 * @author xueyu
 * @date 2020/9/3 11:10
 */
@Data
public class TestBean {
    public String id;
    public String name;
    public TestService testService;
}
