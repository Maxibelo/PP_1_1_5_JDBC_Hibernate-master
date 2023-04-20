package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String hostName = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String userName = "root";
    private static final String password = "gfhjkm1618";
    //public Connection connection;


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(hostName, userName, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
