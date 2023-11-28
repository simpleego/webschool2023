package com.simple.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class DBInsert {
	
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DBInsert() {
		
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
	
	private void sqlInsert() {
		
		// SQL 명령어 준비				
		Scanner kbd = new Scanner(System.in);
		System.out.print("도서아이디 : " );
		int bookID = kbd.nextInt();
		System.out.println();
		
		System.out.print("도서명 : " );
		String bookName = kbd.nextLine();
		System.out.println();
		
		System.out.print("출판사 : " );
		String publisher = kbd.nextLine();	
		System.out.println();
		
		System.out.print("도서가격 : " );
		int price = kbd.nextInt();
		
		// 키보드로 원하는 가격대를 입력하여 검색하시오.
		
		String INSERT_BOOK = "INSERT INTO BOOK VALUES(?,?,?,?)";
		
		System.out.println("SQL : "+INSERT_BOOK);
		try {
			pstmt = con.prepareStatement(INSERT_BOOK);
			pstmt.setInt(1,bookID );
			pstmt.setString(2, bookName);
			pstmt.setString(3, publisher);
			pstmt.setInt(4,price);
			
			int n =  pstmt.executeUpdate();			
			// 테이블 데이터(rs)를 출력한다.
			// 타이틀 출력
			if(n>0) {
				System.out.println("데이터 입력 성공");				
			}else {
				System.out.println("데이터 입력 실패");	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}		
		
	}


	public static void main(String[] args) {
		DBInsert db = new DBInsert();
		db.sqlInsert();
	}

}
