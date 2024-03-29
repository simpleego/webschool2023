package com.simple.vm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simple.vm.CoffeeVO;
import com.simple.vm.SalesCoffeeVO;
import com.simple.vm.SalesVO;
import com.simple.vm.common.JDBCUtil;

@Repository
public class CoffeeDAO {

	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;

	String SELECT_PRODUCT = "SELECT * FROM product;";
	String SELECT_SALESCOFFEE = "SELECT (SELECT pName from product p\r\n" + 
			"				WHERE p.pID = s.pID) AS \"coffeeType\"\r\n" + 
			"        , sum(amount) AS \"salesAmount\" \r\n" + 
			" FROM salescoffee s\r\n" + 
			" GROUP BY s.pID\r\n" + 
			" ORDER BY s.pID;";
	String INSERT_COFFEE = "insert into salescoffee (pID,amount,salesPrice) values(?,?,?)";

	public CoffeeDAO() {
		System.out.println("CoffeeDAO 생성됨");
	}
	
	public List<CoffeeVO> loadProduct() {

		System.out.println("--> loadProduct");

		List<CoffeeVO> list = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_PRODUCT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String pName = rs.getString("pName");
				int pPrice = rs.getInt("pPrice");
				int pID = rs.getInt("pID");
				String pImageUrl = rs.getString("pImageUrl");

				CoffeeVO coffee = new CoffeeVO(pID, pName, pPrice, pImageUrl);
				list.add(coffee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.close(rs, pstmt, conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return list;
	}

	// 판매정보 저장
	public int saveSales(SalesVO vo) {
		System.out.println("---> saveSales");
		int n = 0;

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT_COFFEE);
			pstmt.setInt(1, vo.getpID());
			pstmt.setInt(2, vo.getAmount());
			pstmt.setInt(3, vo.getSalesPrice());

			n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("데이터 입력 성공 :" + n);
			} else {
				System.out.println("데이터 입력 실패 :" + n);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.close(pstmt, conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		return n;
	}
	
	public List<SalesCoffeeVO> loadSalesCoffee() {
		System.out.println("--> loadSalesCoffee");

		List<SalesCoffeeVO> list = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_SALESCOFFEE);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String coffeeType = rs.getString("coffeeType");
				int salesAmount = rs.getInt("salesAmount");

				SalesCoffeeVO salesCoffee = new SalesCoffeeVO(coffeeType, salesAmount);
				System.out.println(" : "+salesCoffee);
				list.add(salesCoffee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.close(rs, pstmt, conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return list;
	}

}
