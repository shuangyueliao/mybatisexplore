package com.shuang;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 不开启自动提交事务
            sqlSession = sqlSessionFactory.openSession(false);
            List<User> list = sqlSession.selectList("com.shuang.test.findAllUsers");
            if (list.size() > 0) {
                sqlSession.update("xxx");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 强制提交事务，如果不设置的话，只有在insert或update才会提交事务，如果selectForUpdate结果为空，无法进行update操作是无法提交事务的
            sqlSession.commit(true);
            sqlSession.close();
        }
    }

}
