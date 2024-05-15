import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    String dbURL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpatth:init.sql'";
    public static Connection getConnection() {
        Connection connection = null;
        connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);


    }
}
