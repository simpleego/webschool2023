package com.simple.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Member extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 PrintWriter out = resp.getWriter();
		 out.println("Hi Member!!");
		 
	}
	
//	public static void main(String[] args) {
//		Member mem = new Member();
//		mem.service(req, resp);
//	}
//	

}
