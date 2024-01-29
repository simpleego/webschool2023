package com.simple.vm.impl;

import java.util.List;

import com.simple.vm.CoffeeVM;
import com.simple.vm.CoffeeVO;
import com.simple.vm.SalesVO;

public class CoffeeServiceImpl implements CoffeeVM {
	
	CoffeeDAO coffeeDAO;
	
	public CoffeeServiceImpl(CoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	@Override
	public List<CoffeeVO> loadProduct() {
		
		return coffeeDAO.loadProduct();
	}

	@Override
	public int saveSales(SalesVO vo) {
		
		return coffeeDAO.saveSales(vo);
	}

}
