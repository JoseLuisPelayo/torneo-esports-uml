package org.torneo.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionMy8 {

    private static Connection conn;

    private final String url = "jdbc:mysql://localhost:3306/torneo?serverTimezone=UTC";
    private final String user = "root";
    private final String password = "jose1986";

    private ConnectionMy8() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("\nConexion establecida");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nCONEXION NOOO ESTABLECIDA");
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            new ConnectionMy8();
        }
        return conn;
    }
}
