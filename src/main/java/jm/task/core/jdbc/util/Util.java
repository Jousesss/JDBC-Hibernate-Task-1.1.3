package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String dataBaseUrl = "url";
    private static final String dataBaseUser = "name";
    private static final String dataBasePassword = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dataBaseUrl,dataBaseUser,dataBasePassword);
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.err.println("Ошибка получения connection: ");
            e.printStackTrace();
        }
        return connection;
    }

    public static Statement getStatement() {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
        } catch (Exception e) {
            System.err.println("Ошибка получения statement: ");
            e.printStackTrace();
        }
        return statement;
    }
}
