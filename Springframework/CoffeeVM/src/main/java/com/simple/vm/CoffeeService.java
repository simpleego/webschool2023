package com.simple.vm;

import java.util.List;

public interface CoffeeService {
	
	// 커피제품 load
	List<CoffeeVO> loadProduct();	
	
	// 커피판매량 load
	List<SalesCoffeeVO> loadSalesCoffee();	
	
	// 커피 판매 정보 저장
	int saveSales(SalesVO vo, String coffee);
}
