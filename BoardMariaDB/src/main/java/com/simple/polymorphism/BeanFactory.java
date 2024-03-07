package com.simple.polymorphism;

public class BeanFactory {
	
	public Object getBean(String beanName){
		
		if(beanName.equals("samsung")) {
			return new SamsungTV("ㅇㅇ");
		}
		
		if(beanName.equals("lg")) {
			return new LgTV("ㅅㅅ");
		}
		
		return null;
	}
	

}
