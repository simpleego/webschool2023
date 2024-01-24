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
 * Servlet implementation class LoadProduct
 */
@WebServlet("/loadProduct")
public class LoadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");		
		PrintWriter writer = response.getWriter();
		
		
		List<Product> productList = new ArrayList<Product>();
		productList = loadProduct();
		
		// json 포맷으로 변환하여 응답
		JSONObject totalObject = new JSONObject();
		JSONArray productsArray = new JSONArray();
		
		for(Product item : productList) {
			JSONObject productInfo = new JSONObject();
			productInfo.put("type", item.pName);
			productInfo.put("pPrice", item.pPrice);
			productInfo.put("pAmount", item.pAmount);
			productInfo.put("pImageUrl", item.pImageUrl);
			productsArray.add(productInfo);
		}
		
		totalObject.put("products",productsArray);
		
		String productInfo = totalObject.toJSONString();
		System.out.println("products:"+productInfo);
		
		// 배열객체를 문자열로 변환하여 전송
		writer.print(productInfo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
private List<Product> loadProduct() {
		
		PreparedStatement pstmt = null;
		Connection conn=null;
		ResultSet rs = null;
		
		List<Product> list = new ArrayList<>();
		
		String SELECT_PRODUCT = "SELECT * FROM product;"; 
		
        System.out.println("SQL : " + SELECT_PRODUCT);

        try {
        	conn = DBConnect.getConnection();
            pstmt = conn.prepareStatement(SELECT_PRODUCT);
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	String pName = rs.getString("pName");
            	int pPrice  = rs.getInt("pPrice");   
            	int pAmount  = rs.getInt("pAmount");   
            	String pImageUrl  = rs.getString("pImageUrl");   
            	
            	Product product = new Product(pName, pPrice, pAmount, pImageUrl);
            	list.add(product);
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

}
