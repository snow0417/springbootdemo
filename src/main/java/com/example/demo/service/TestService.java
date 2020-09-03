package com.example.demo.service;

import com.example.demo.mybatis.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xueyu
 * @date 2020/6/30 19:39
 */
@Slf4j
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

}
