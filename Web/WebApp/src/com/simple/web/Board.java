package com.simple.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class Board extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자에게 보내는 방식을 결정
		resp.setCharacterEncoding("UTF-8");
		// Content 해석 방식을 알려줌
		resp.setContentType("text/html; charset=UTF-8");
		
		 PrintWriter out = resp.getWriter();
		 
		 String cnt_ = req.getParameter("cnt");
		 String msg = req.getParameter("msg");
		 
		 int cnt = Integer.parseInt(cnt_);
		 
		 for(int i=1; i<=cnt; i++) {
			 out.println("<h1>"+i+": "+msg+" Board</h1>");
		 }
		 
	}
	
//	public static void main(String[] args) {
//		Member mem = new Member();
//		mem.service(req, resp);
//	}
//	

}
