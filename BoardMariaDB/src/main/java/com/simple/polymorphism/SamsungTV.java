package com.simple.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
//	@Qualifier("apple")
//	@Resource(name="apple")
	@Autowired
	Speaker speaker;
	int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성 Setter 사용시 호출됨");
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV 객체 생성");
		this.speaker =  speaker;
		this.price = price;
	}	

	public SamsungTV(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("TV 가격 주입됩니다.");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("스프커 의존성 주입됩니다.");
	}

	public void initMethod() {
		System.out.println("초기화 작업을 수행합니다.");
	}
	
	public void destroyMethod() {
		System.out.println("객체 소멸전에 처리할 작업을 수행합니다.");
	}
		
	public void turnOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
		//speaker.volumeUp();
		// System.out.println("SamsungTV---소리 올린다.");
	}
	public void volumeDown() {
		speaker.volumeDown();
		//speaker.volumeDown();
		// System.out.println("SamsungTV---소리 내린다.");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");		
	}	
	
	public void showTV() {
		System.out.println("가격:"+price);		
	}

}
