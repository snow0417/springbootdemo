package com.example.demo.service;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.config.DS;
import com.example.demo.mybatis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xueyu
 * @date 2020/6/30 19:39
 */
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    @DS("slave")
    public TestEntity get(){
        return testMapper.selectById(1);
    }
}
