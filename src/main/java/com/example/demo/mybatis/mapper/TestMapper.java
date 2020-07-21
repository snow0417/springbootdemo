package com.example.demo.mybatis.mapper;

import com.example.demo.Model.TestEntity;
import com.example.demo.mybatis.config.DS;
import org.apache.ibatis.annotations.Param;

/**
 * @author xueyu
 * @date 2020/6/30 18:34
 */
public interface TestMapper {
    TestEntity selectById(@Param("id") Integer id, @Param("table")String table);

    TestEntity selectByIdForUpdate(@Param("id") Integer id);

    void update(@Param("id") Integer id, @Param("name")String name);

    @DS("slave")
    TestEntity selectReadById(@Param("id")Integer id);
}
