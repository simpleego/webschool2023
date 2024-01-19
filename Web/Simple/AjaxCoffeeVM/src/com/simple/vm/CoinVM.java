package com.simple.vm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class CoinVM
 */
@WebServlet("/coins")
public class CoinVM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoinVM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer =  response.getWriter();

		String coin_ = request.getParameter("coin");	
		System.out.println("coin:"+coin_);
		
		int coin = 0;	
		int returnCoins = 0;
		int valance = 0;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("valance") != null) {
			valance = (int) session.getAttribute("valance");
		}
		
		JSONObject coffeeInfo = new JSONObject();		
		
		if( coin_ != null ) {
			coin = Integer.parseInt(coin_);
			// 동전 누적
			
			if(coin == 0) {
				returnCoins = valance;
				valance = 0;
				coffeeInfo.put("retCoins", returnCoins);
			}else {
				valance += coin;
				coffeeInfo.put("valance", valance);
			}
		}		
		
		String coffeeData = coffeeInfo.toJSONString();
		writer.print(coffeeData);
		session.setAttribute("valance",valance);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
