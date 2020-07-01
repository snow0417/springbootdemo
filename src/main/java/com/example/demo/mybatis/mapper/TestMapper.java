package com.example.demo.mybatis.mapper;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.config.DS;
import org.apache.ibatis.annotations.Param;

/**
 * @author xueyu
 * @date 2020/6/30 18:34
 */
public interface TestMapper {
    TestEntity selectById(@Param("id") Integer id);

    @DS("slave")
    TestEntity selectReadById(@Param("id")Integer id);
}
