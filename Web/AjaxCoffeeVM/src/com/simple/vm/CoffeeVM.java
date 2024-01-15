package com.simple.vm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class CoffeeVM
 */
@WebServlet("/coffee")
public class CoffeeVM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoffeeVM() {
		super();
		// TODO Auto-generated constructor stub
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

		PrintWriter writer = response.getWriter();

		String coffee = request.getParameter("coffee");

		int valance = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("valance") != null) {
			valance = (int) session.getAttribute("valance");
		}

		// 커피 판매 처리
		saleCoffee(coffee, valance,request, response, 
				   session, writer);
	}

	private void saleCoffee(String coffee, int valance, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, PrintWriter writer) {
		
		// 커피판매
		int price = 0;
		String returnCoffee = "";

		if (coffee.equals("밀크커피")) {
			valance -= 300;
			returnCoffee = "milkOut.png";
			price = 300;
		} else if (coffee.equals("프림커피")) {
			valance -= 300;
			returnCoffee = "creamOut.png";
			price = 300;
		} else if (coffee.equals("설탕커피")) {
			valance -= 200;
			returnCoffee = "sugarOut.png";
			price = 200;
		} else if (coffee.equals("블랙커피")) {
			valance -= 200;
			returnCoffee = "blackOut.png";
			price = 200;
		}

		JSONObject coffeeInfo = new JSONObject();

		coffeeInfo.put("valance", valance);
		coffeeInfo.put("coffee", returnCoffee);
        
		String coffeeData = coffeeInfo.toJSONString();
		writer.print(coffeeData);
		
		saveSalesDB(coffee, 1, price);
		session.setAttribute("valance", valance);
	}
	
	private void saveSalesDB(String coffee, int amount, int price) {
		// 
		PreparedStatement pstmt = null;
		Connection conn=null;
		
		String INSERT_COFFEE = "insert into salescoffee (pName,amount,price) values(?,?,?)";
        System.out.println("SQL : " + INSERT_COFFEE);

        try {
        	conn = DBConnect.getConnection();
            pstmt = conn.prepareStatement(INSERT_COFFEE);
            pstmt.setString(1, coffee);
            pstmt.setInt(2, amount);
            pstmt.setInt(3, price);
            int n = pstmt.executeUpdate();
            if (n > 0) {
                System.out.println("데이터 입력 성공 :" + n);
            } else {
                System.out.println("데이터 입력 실패 :" + n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	DBConnect.close(pstmt, conn);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
