package com.lviat.util.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis Util.
 *
 * @author LviatYi
 * @version 1.0
 * @className MybatisUtil
 * @date 2021/8/22
 */
public class MybatisUtil {
    public static SqlSession getSession() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            inputStream = Resources.getResourceAsStream(resource);
            sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return sqlSession;
    }
}
