package com.simple.vm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	public DBConnect() {
    }

    public static Connection getConnection() {
        //String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String url = "jdbc:mariadb://localhost:3306/coffeeMachine";
        String userid = "root";
        String pwd = "pjc0129";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(url, userid, pwd);
        } catch (ClassNotFoundException | SQLException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static void close(PreparedStatement stmt, Connection conn) {
    	
        if (stmt != null) {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                    System.out.println("자원해제됩니다..");
                }
            } catch (SQLException var4) {
                throw new RuntimeException(var4);
            }
        }

        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException var3) {
                throw new RuntimeException(var3);
            }
        }

    }

    public static void close(PreparedStatement stmt, Connection conn, ResultSet rs) {
        if (rs != null) {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException var6) {
                throw new RuntimeException(var6);
            }
        }

        if (stmt != null) {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException var5) {
                throw new RuntimeException(var5);
            }
        }

        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException var4) {
                throw new RuntimeException(var4);
            }
        }

    }

}
