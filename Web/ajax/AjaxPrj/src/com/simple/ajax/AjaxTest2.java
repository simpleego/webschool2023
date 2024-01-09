package com.simple.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTest1
 */
@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get로 전송됨");
		doHandler(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post로 전송됨");
		doHandler(request, response);
	}
	
	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		response.setContentType("text/html; charset=utf-8");
		
		// 도서정보 XML --> 문자열로 포맷
		String result="";
		PrintWriter writer = response.getWriter();
		result="<main>"+
				"<book>"+
				"<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>"+
				"<writer><![CDATA[인포북스 저|이병승]]></writer>"+
				"<image><![CDATA[http://localhost:8080/AjaxPrj/image/image1.jpg]]></image>"+
				"</book>"
				+ "<book>"+
				"<title><![CDATA[모두의 파이썬]]></title>"+
				"<writer><![CDATA[길벗 저|이승찬]]></writer>"+
				"<image><![CDATA[http://localhost:8080/AjaxPrj/image/image2.jpg]]></image>"+
				"</book>"
				+ "</main>";
		System.out.println(result);
		writer.print(result);		
	}

}
