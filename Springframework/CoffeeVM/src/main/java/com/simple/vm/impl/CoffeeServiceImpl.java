package com.simple.vm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.vm.CoffeeService;
import com.simple.vm.CoffeeVO;
import com.simple.vm.SalesCoffeeVO;
import com.simple.vm.SalesVO;

@Service("coffeeService")
public class CoffeeServiceImpl implements CoffeeService {
	
	@Autowired
	CoffeeDAO coffeeDAO;
	
	public CoffeeServiceImpl() {
		System.out.println("CoffeeService 생성됨");		
	}
	
	public CoffeeServiceImpl(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
		System.out.println("CoffeeService 1 생성됨");	
	}

	@Override
	public List<CoffeeVO> loadProduct() {
		
		return coffeeDAO.loadProduct();
	}

	@Override
	public int saveSales(SalesVO vo, String coffee )	{
		// 커피판매
		int price = 0;
		int pId = 0;

		if (coffee.equals("밀크커피")) {
			price = 300;
			pId = 1;
		} else if (coffee.equals("프림커피")) {
			price = 300;
			pId = 2;
		} else if (coffee.equals("설탕커피")) {
			price = 200;
			pId = 3;
		} else if (coffee.equals("블랙커피")) {
			price = 200;
			pId = 4;
		}
		
		vo.setAmount(1);
		vo.setpID(pId);
		vo.setSalesPrice(price);
		
		return coffeeDAO.saveSales(vo);
	}

	@Override
	public List<SalesCoffeeVO> loadSalesCoffee() {
		
		return coffeeDAO.loadSalesCoffee();
	}

}
