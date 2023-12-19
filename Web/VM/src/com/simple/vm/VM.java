package com.simple.vm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VM
 */
@WebServlet("/vm")
public class VM extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VM() {    	
    	//valance = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String coin_ = request.getParameter("coin");
		int coin = 0;	
		int valance = (int) request.getAttribute("valance");
		
		if(!coin_.equals("")) {
			coin = Integer.parseInt(coin_);
			// 밀커커피 판매 처리(300원)
			valance = coin - 300;
		}	
		
		request.setAttribute("valance", valance);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("index.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
