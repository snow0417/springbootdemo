package com.example.demo.service;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xueyu
 * @date 2020/6/30 19:39
 */
@Slf4j
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    @Transactional
    public void t1(){
        TestEntity entity = testMapper.selectByIdForUpdate(1);
        log.info("t1 get entity:{}", entity);
        try {
            Thread.sleep(4000);
        }catch (Exception e){

        }
        testMapper.update(1, "lucy");
        log.info("t1 update");
    }


    @Transactional
    public void t2(){
        TestEntity entity = testMapper.selectById(1);
        log.info("t2 get entity:{}", entity);
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        String name = entity.getName() + "1";
        testMapper.update(1, name);
        log.info("t2 update");
    }
}
