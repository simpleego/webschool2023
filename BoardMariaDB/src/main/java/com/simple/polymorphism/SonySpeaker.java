package com.simple.polymorphism;

import org.springframework.stereotype.Component;

//@Component("sony")
public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("소니 스피커 생성되었습니다.");
	}
	
	public void volumeUp() {
		System.out.println("소리를 키운다");
	}
	
	public void volumeDown() {
		System.out.println("소리를 낮춘다");
	}

}
