package com.example.demo.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author xueyu
 * @date 2020/9/3 15:50
 */
public class JdbcClient {

    public static void main(String[] args) throws Exception{

//        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://39.105.185.187:3306/master_test";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from test where id = 1");
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            Object o1 = resultSet.getObject(1);
            Object o2 = resultSet.getObject(2);

            int i = 0;
        }
    }
}
