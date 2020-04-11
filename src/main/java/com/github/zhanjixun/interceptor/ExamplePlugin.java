package com.github.zhanjixun.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * 示例拦截器
 *
 * @author :zhanjixun
 * @date : 2020/04/11 23:28
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class ExamplePlugin implements Interceptor {

    private String name;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(name + "拦截器被调用");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        name = properties.getProperty("name");
    }
}