package com.simple.vm;

import java.io.IOException;

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
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String coin_ = request.getParameter("coin");
		String change = request.getParameter("change");
		String coffee = request.getParameter("coffee");
		String logout = request.getParameter("logout");
		
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
		}	
		
		
		// 동전 반환
		if(change != null ) {
			int returnChange = valance;
			valance = 0;
			session.setAttribute("change", returnChange);				
		}
		
		// 커피판매
		if(coffee != null) {
			String returnCoffee="";
			if(coffee.equals("밀크커피")) {
				valance -= 300;
				returnCoffee = "밀크커피";
			}else if(coffee.equals("프림커피")) {
				valance -= 300;
				returnCoffee = "프림커피";
			}else if(coffee.equals("설탕커피")) {
				valance -= 200;
				returnCoffee = "설탕커피";
			}else if(coffee.equals("블랙커피")) {
				valance -= 200;
				returnCoffee = "블랙커피";
			}
			session.setAttribute("coffee", returnCoffee);	
		}		
		
				

		// check button
		checkButtons(valance, session);
				
		session.setAttribute("valance", valance);
		
		// 로그아웃 처리
		if( logout != null && session != null) {			
			session.invalidate();
		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("index.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void checkButtons(int valance, HttpSession session) {
		
		String btnMilk="";
		String btnCream="";
		String btnSugar="";
		String btnBlack="";
		
		if ( valance >= 300) {
			// 모든 버튼 활성화
			btnMilk="enable";
			btnCream="enable";
			btnSugar="enable";
			btnBlack="enable";
		}else if(valance >= 200) {
			// 해당 버튼 활성화
			btnSugar="enable";
			btnBlack="enable";
		}
		
		session.setAttribute("btnMilk", btnMilk);
		session.setAttribute("btnCream", btnCream);
		session.setAttribute("btnSugar", btnSugar);
		session.setAttribute("btnBlack", btnBlack);
		
	}

}
