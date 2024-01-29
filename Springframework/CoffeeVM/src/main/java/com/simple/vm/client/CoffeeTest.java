package com.simple.vm.client;

import java.util.ArrayList;
import java.util.List;

import com.simple.vm.CoffeeVO;
import com.simple.vm.SalesVO;
import com.simple.vm.impl.CoffeeDAO;
import com.simple.vm.impl.CoffeeServiceImpl;

public class CoffeeTest {

	public static void main(String[] args) {	
		
		SalesVO vo = new SalesVO();
		CoffeeDAO coffeeDAO = new CoffeeDAO();
		CoffeeServiceImpl coffeeService = new CoffeeServiceImpl(coffeeDAO);
		
		// CoffeeDAO 호출
		vo.setpID(1);
		vo.setAmount(1);
		vo.setSalesPrice(300);
		
		int ok = coffeeService.saveSales(vo);
		
		if(ok >0) {
			System.out.println("판매정보 저장 성공");
		}else {
			System.out.println("판매정보 저장 실패");			
		}
		
		
		
		/*
		 * List<CoffeeVO> list = new ArrayList<>();
		 * 
		 * CoffeeDAO coffeeDAO = new CoffeeDAO();
		 * 
		 * list = coffeeDAO.loadProduct();
		 * 
		 * for(CoffeeVO coffee : list) { System.out.println("제품명:"+coffee.getpName());
		 * System.out.println("제품가격:"+coffee.getpPrice());
		 * System.out.println("제품이미지:"+coffee.getpImageUrl()); }
		 */
		
		
	}

}
