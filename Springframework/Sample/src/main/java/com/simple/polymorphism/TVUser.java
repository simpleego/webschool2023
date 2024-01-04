package com.simple.polymorphism;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		//BeanFactory factory = new BeanFactory();
		AbstractApplicationContext factory =  new GenericXmlApplicationContext("applicationContext.xml");	
		
		System.out.println("-----------------------");
			
		TV tv1 = (TV) factory.getBean("tv");
		
		CollecBean bean = (CollecBean) factory.getBean("collectionBean");
		
		List<String> addressList = bean.getAddressList();
		
		for(String str : addressList) {
			System.out.println(str.toString());
		}
		
		tv1.volumeUp();
		
		SamsungTV tv2 = (SamsungTV)tv1; 
		tv2.showTV();
		
		factory.close();
	}

}
