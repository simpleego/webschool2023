package com.simple.vm.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.simple.vm.CoffeeService;
import com.simple.vm.SalesVO;
import com.simple.vm.impl.CoffeeDAO;
import com.simple.vm.impl.CoffeeServiceImpl;

public class CoffeeTest {

	public static void main(String[] args) {	
		
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. 컨테이너로부터 필요한 객체를 요청
		CoffeeService coffeeService = (CoffeeService) container.getBean("coffeeService");
		
		SalesVO vo = new SalesVO();
		//CoffeeServiceImpl coffeeService = new CoffeeServiceImpl(coffeeDAO);
		
		// CoffeeDAO 호출
		vo.setpID(2);
		vo.setAmount(1);
		vo.setSalesPrice(300);
		
		int ok = coffeeService.saveSales(vo);
		
		if(ok >0) {
			System.out.println("판매정보 저장 성공");
		}else {
			System.out.println("판매정보 저장 실패");			
		}
		
		container.close();	
		
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
