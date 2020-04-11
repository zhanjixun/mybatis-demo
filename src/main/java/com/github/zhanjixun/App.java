package com.github.zhanjixun;

import com.github.zhanjixun.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 参考https://mybatis.org/mybatis-3/zh/getting-started.html
 * 创建的mybatis使用示例项目
 * 调试mybatis源码用例
 *
 * @author zhanjixun
 */
public class App {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        System.out.println(mapper.selectById(1));
        System.out.println(mapper.selectByName("张三"));

        System.out.println(mapper.updateUser(20, 1));

    }

}
