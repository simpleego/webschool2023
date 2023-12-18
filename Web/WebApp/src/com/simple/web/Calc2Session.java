package com.simple.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.resources.HttpserverMessages;

/**
 * Servlet implementation class Calc2
 */
@WebServlet("/calc21")
public class Calc2Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String value_ = request.getParameter("value");
		String op = request.getParameter("operator");
		
		// 저장소 준비(Application) : 서블릿저장소(Servlet Context)		
		//ServletContext application = request.getServletContext();
		
		// 세션 저장소 준비
		HttpSession session =  request.getSession();
		
		// 정수 공간 확보
		int value = 0;
		
		if( !value_.equals("")) {
			value = Integer.parseInt(value_);
		}
		
		int result = 0;
		
		if(op.equals("=")) {
			// 저장된 값을 이용해서 계산하라
			int value2 = (int) session.getAttribute("value");
			String op2 = (String) session.getAttribute("op");
			if(op2.equals("+")) {
				result = value + value2;
			}else {
				result = value2 - value;				
			}			
			response.getWriter().printf("결과값 : %d", result);
		}else {
			// 값을 저장하라, 저장소에 저장한다.
			session.setAttribute("value", value);
			session.setAttribute("op", op);
			System.out.println("value :"+value_);
			System.out.println("operator :"+op);
		}		
		
	}

}
