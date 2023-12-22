package com.simple.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB 접속
		// SQL 수행(공지사항 리스트 요청)
		// 공지사항 결과 받기( ArrayList )
		int id = Integer.parseInt(request.getParameter("id"));
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM NOTICE WHERE ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "system", "pjc0129");	
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);	
			rs.next();
			
			String title = rs.getString("TITLE");
			Date regDate = rs.getDate("REGDATE");
			String writerId = rs.getString("WRITER_ID");
			String hit = rs.getString("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			
			// 모델화 한 후 request(저장소)에 저장하여 전달
			request.setAttribute("title", title);
			request.setAttribute("regDate",regDate);
			request.setAttribute("writerId",writerId);
			request.setAttribute("hit",hit);
			request.setAttribute("files",files);
			request.setAttribute("content",content);
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		// 저장소에 있는 데이터를 View에 전달
		request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
