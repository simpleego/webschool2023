package com.simple.vm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VM
 */
@WebServlet("/coins")
public class VMCoins extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VMCoins() {
		// valance = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer =  response.getWriter();

		String coin_ = request.getParameter("coin");
		
		System.out.println("coin:"+coin_);
		
		int coin = 0;	
		int valance = 0;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("valance") != null) {
			valance = (int) session.getAttribute("valance");
		}		
		
		if( coin_ != null ) {
			coin = Integer.parseInt(coin_);
			// 동전 누적
			valance += coin;
			session.setAttribute("valance",valance);
		}
		
		writer.print(valance);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
