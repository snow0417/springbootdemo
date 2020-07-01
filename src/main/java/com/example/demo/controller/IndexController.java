package com.example.demo.controller;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.mapper.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueyu
 * @date 2020/5/14 17:02
 */
@RestController
public class IndexController {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TestService testService;

    @GetMapping("/read")
    public void testRead(){
        TestEntity entity = testMapper.selectById(1);
        TestEntity entity1 = testMapper.selectReadById(1);
    }
}
