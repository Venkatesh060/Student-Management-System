package util;

import java.sql.*;

public class DBUtil {
    public static Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sms",
            "root",
            "admin"
        );
    }
}
