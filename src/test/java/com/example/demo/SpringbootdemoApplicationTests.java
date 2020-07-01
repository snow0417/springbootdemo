package com.example.demo;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootdemoApplicationTests {
	@Autowired
	private TestMapper testMapper;


	@Test
	void contextLoads() {
		TestEntity entity = testMapper.selectById(1);
		TestEntity entity1 = testMapper.selectReadById(1);
	}

}
