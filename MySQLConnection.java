/**
 * 1972003 Ilman Nawali
 */

package com.ilman.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/praktikumdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "garut123";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
