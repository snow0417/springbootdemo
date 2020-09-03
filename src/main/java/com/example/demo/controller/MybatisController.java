package com.example.demo.controller;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @GetMapping("/read")
    public void testRead() throws Exception {
        long time = System.currentTimeMillis();
        TestEntity entity = testMapper.selectById(1, "test");
        log.info("time1:{}", System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        TestEntity entity2 = testMapper.selectById(1, "test");
        log.info("time2:{}", System.currentTimeMillis() - time);
        log.info("get entity:{}", entity);
    }

    @GetMapping("/read2")
    public void testRead2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper2 = sqlSession.getMapper(TestMapper.class);
        long time = System.currentTimeMillis();
        TestEntity entity = testMapper2.selectById(1, "test");
        log.info("time1:{}", System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        TestEntity entity2 = testMapper2.selectById(1, "test");
        log.info("time2:{}", System.currentTimeMillis() - time);
        log.info("get entity:{}", entity);
    }
}
