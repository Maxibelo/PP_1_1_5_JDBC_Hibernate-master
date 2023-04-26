package jm.task.core.jdbc.util;

import org.hibernate.cfg.Configuration;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String hostName = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String userName = "root";
    private static final String password = "gfhjkm1618";
    public static Connection connection;
    private static Util instance;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.URL, hostName);
            settings.put(Environment.USER, userName);
            settings.put(Environment.PASS, password);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

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
