package Zavkhoz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
    static String JDBC_url = "jdbc:postgresql://localhost:5432/equipments?currentSchema=public&user=postgres&password=123";

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
