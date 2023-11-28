package com.simple.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class DBList {
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public DBList() {
		
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
	
	private void sqlList() {
		
		// SQL 명령어 준비		
		int minPrice=10000;
		int maxPrice=20000;
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("최소가격 : " );
		minPrice = kbd.nextInt();
		System.out.print("최고가격 : " );
		maxPrice = kbd.nextInt();			
		
		// 키보드로 원하는 가격대를 입력하여 검색하시오.
		
		String SELECT_ALL_BOOK = "SELECT * FROM BOOK WHERE PRICE >= "+
				minPrice + " and price <= "+maxPrice;
		
		System.out.println("SQL : "+SELECT_ALL_BOOK);
		try {
			stmt = con.createStatement();
			rs =  stmt.executeQuery(SELECT_ALL_BOOK);
			
			// 테이블 데이터(rs)를 출력한다.
			// 타이틀 출력
			System.out.println("도서ID 도서명  출판사  도서가격");
			
			while(rs.next()) {
				int bookid = rs.getInt("BookID");
				String bookName = rs.getString(2);
				String publisher = rs.getString(3);
				int price = rs.getInt("PRICE");
				
				System.out.printf("%d %s %s %d \n",bookid,bookName, publisher, price);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}		
		
	}


	public static void main(String[] args) {
		DBList db = new DBList();
		db.sqlList();
	}

}
