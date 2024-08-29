package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection () {
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "rmxxxxxx", "xxxxxx");
        } catch(SQLException error) {
            error.printStackTrace();
        }
        return connection;
    }
}
