package com.example.demo.controller;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueyu
 * @date 2020/8/27 15:33
 */
@Slf4j
@RequestMapping("/mybatis")
@RestController
public class MybatisController {
    @Autowired
    private TestMapper testMapper;

    @GetMapping("/read")
    public void testRead() throws Exception {
        TestEntity entity = testMapper.selectById(1, "test");
        log.info("get entity:{}", entity);
    }

}
