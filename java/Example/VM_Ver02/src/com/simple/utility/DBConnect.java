package com.simple.utility;

import java.sql.*;

public class DBConnect {

    public static Connection getConnection(){
        // 접속할 주소
        // 접속할 계정 및 비밀번호
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid="c##madang";
        String pwd = "madang";

        // DB 접속
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(url,userid,pwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement stmt, Connection conn){
        if(stmt != null){
            try {
                if(!stmt.isClosed())
                    stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(conn != null){
            try {
                if(!conn.isClosed())
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void close(PreparedStatement stmt,
                             Connection conn,
                             ResultSet rs){
        if(rs != null){
            try {
                if(!rs.isClosed())
                    rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(stmt != null){
            try {
                if(!stmt.isClosed())
                    stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(conn != null){
            try {
                if(!conn.isClosed())
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
