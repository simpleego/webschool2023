package com.simple.vm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class LoadCoffeeSales
 */
@WebServlet("/loadcoffee")
public class LoadCoffeeSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCoffeeSales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");		
		PrintWriter writer = response.getWriter();
		
		List<CoffeeSales> list = new ArrayList<>();
		
		list = loadCoffee();
		JSONObject totalObject = new JSONObject();
		JSONArray coffeesArray = new JSONArray();
		
		for(CoffeeSales item : list) {
			JSONObject coffeeInfo = new JSONObject();
			System.out.println("커피 종류 : "+item.coffeeType);
			System.out.println("판매량 : "+item.amount);
			coffeeInfo.put("type", item.coffeeType);
			coffeeInfo.put("amount", item.amount);
			coffeesArray.add(coffeeInfo);
		}
		
		totalObject.put("coffees",coffeesArray);
		
		String jsonInfo = totalObject.toJSONString();
		System.out.println("coffees:"+jsonInfo);
		
		// 배열객체를 문자열로 변환하여 전송
		writer.print(jsonInfo);
		
	}

	private List<CoffeeSales> loadCoffee() {
		
		PreparedStatement pstmt = null;
		Connection conn=null;
		ResultSet rs = null;
		
		List<CoffeeSales> list = new ArrayList<>();
		
		String SELECT_COFFEE = "SELECT pName 커피, sum(amount) 판매량 \r\n" + 
				" FROM salescoffee\r\n" + 
				" GROUP BY pName \r\n" + 
				" ORDER BY pName;";
		
        System.out.println("SQL : " + SELECT_COFFEE);

        try {
        	conn = DBConnect.getConnection();
            pstmt = conn.prepareStatement(SELECT_COFFEE);
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	String coffeeType = rs.getString("커피");
            	int amount  = rs.getInt("판매량");   
            	
            	CoffeeSales coffeeSales = new CoffeeSales(coffeeType, amount);
            	list.add(coffeeSales);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	DBConnect.close(pstmt, conn, rs);;
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        
        return list;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
