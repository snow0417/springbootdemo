package com.example.demo.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @author xueyu
 * @date 2020/8/27 15:28
 */
@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class TestPlugin implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
//        Object[] args = invocation.getArgs();
//        HashMap<String, Object> res = (HashMap<String, Object>)invocation.getArgs()[1];
//        res.put("id", 2);
//        res.put("param1", 2);
//        log.info("interceptor:{}", args);

        return invocation.proceed();
    }
}
