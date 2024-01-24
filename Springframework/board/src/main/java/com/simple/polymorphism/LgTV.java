package com.simple.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("ltv")
public class LgTV implements TV{
	
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println(" LgTV 생성되었습니다.");
	}
	public LgTV(String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("LgTV---소리 올린다.");		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("LgTV---소리 내린다.");		
	}

}
