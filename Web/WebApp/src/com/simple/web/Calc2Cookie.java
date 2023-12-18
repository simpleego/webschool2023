package com.simple.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.resources.HttpserverMessages;

/**
 * Servlet implementation class Calc2
 */
@WebServlet("/calc22")
public class Calc2Cookie extends HttpServlet {
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
		//HttpSession session =  request.getSession();
		
		// Cookie 저장소 준비
		Cookie[] cookies = request.getCookies();
		
		// 정수 공간 확보
		int value = 0;
		
		if( !value_.equals("")) {
			value = Integer.parseInt(value_);
		}
		
		int result = 0;
		int value2=0;
		String op2=null;
		
		if(op.equals("=")) {
			// 저장된 값을 이용해서 계산하라
			for( Cookie c : cookies) {
				if(c.getName().equals("value")) {
					value2 = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			for( Cookie c : cookies) {
				if(c.getName().equals("op")) {
					op2 = c.getValue();
					break;
				}
			}			
				
			System.out.println("op2 : "+op2);
			if(op2.equals("+")) {
				result = value + value2;
			}else {
				result = value2 - value;				
			}			
			response.getWriter().printf("결과값 : %d", result);
		}else {
			// 값을 저장하라, 저장소에 저장한다.
			Cookie valueCookie = new Cookie("value", String.valueOf(value));
			Cookie opCookie = new Cookie("op", op);
			
			// path 설정
			//valueCookie.setPath("/calc22");
			//opCookie.setPath("/calc22");
			
			// 쿠키 유효시간-24시간으로 설정
			valueCookie.setMaxAge(60*60*24*365);
			opCookie.setMaxAge(60*60*24);
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			System.out.println("value :"+value_);
			System.out.println("operator :"+op);
		}		
		
	}

}
