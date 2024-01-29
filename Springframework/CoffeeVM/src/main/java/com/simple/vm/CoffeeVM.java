package com.simple.vm;

import java.util.List;

public interface CoffeeVM {
	
	// 커피제품 load
	List<CoffeeVO> loadProduct();	
	
	// 커피 판매 정보 저장
	int saveSales(SalesVO vo);
	
	
}
