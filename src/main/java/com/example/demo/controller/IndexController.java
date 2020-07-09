package com.example.demo.controller;

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
    public void testRead() throws Exception{
        Thread t1 = new Thread(()->{
            testService.t1();

        });
        t1.start();
        Thread.sleep(1000);

        Thread t2 = new Thread(()->{
           testService.t2();
        });
        t2.start();

        Thread.sleep(10000);
    }
}
