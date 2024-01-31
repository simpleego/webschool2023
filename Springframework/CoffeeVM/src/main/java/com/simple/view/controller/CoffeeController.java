package com.simple.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.vm.CoffeeService;
import com.simple.vm.CoffeeVO;
import com.simple.vm.SalesVO;

@Controller
public class CoffeeController {

	@Autowired
	CoffeeService coffeeService;

	@RequestMapping("/loadProduct.vm")
	@ResponseBody
	public List<CoffeeVO> loadProduct() {

		List<CoffeeVO> productList = new ArrayList<>();

		System.out.println("loadProduct 호출");
		productList = coffeeService.loadProduct();

		return productList;		
	}
	
	@RequestMapping("/coffee.vm")
	public int saveSales(SalesVO vo) {			
		return coffeeService.saveSales(vo);		
	}

}
