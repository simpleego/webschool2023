package com.simple.polymorphism;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		//BeanFactory factory = new BeanFactory();
		AbstractApplicationContext factory =  new GenericXmlApplicationContext("applicationContext.xml");	
		
		System.out.println("-----------------------");
				
		TV tv = (TV) factory.getBean("tv");	
		
		tv.volumeUp();
		
		factory.close();
	}

}
