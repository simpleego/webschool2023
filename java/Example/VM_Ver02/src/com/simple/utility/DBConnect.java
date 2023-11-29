package com.simple.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    Connection con;

    public DBConnect() {
        // 접속할 주소
        // 접속할 계정 및 비밀번호
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid="c##madang";
        String pwd = "madang";

        // 연결할 드라이버 로드
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // DB 접속
        try {
            con = DriverManager.getConnection(url,userid,pwd);
            System.out.println("DB 접속 성공..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon(){
        return con;
    }

}
