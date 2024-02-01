package com.simple.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.vm.CoffeeService;
import com.simple.vm.CoffeeVO;
import com.simple.vm.SalesCoffeeVO;
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
	public void saveSales(SalesVO vo,
			@RequestParam(value = "coffee", 
			defaultValue = "밀크커피", 
			required = false) String coffee
			) {	
		
		System.out.println("coffee :"+ coffee);
		coffeeService.saveSales(vo, coffee);		
	}
	
	@RequestMapping("/loadSalesCoffee.vm")
	@ResponseBody
	public List<SalesCoffeeVO> loadSalesCoffee() {

		List<SalesCoffeeVO> salesList = new ArrayList<>();

		System.out.println("loadSalesCoffee 호출");
		salesList = coffeeService.loadSalesCoffee();

		return salesList;		
	}

}
