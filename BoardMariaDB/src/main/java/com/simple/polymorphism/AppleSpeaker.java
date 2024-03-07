package com.simple.polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println(" 애플 스피커 생성되었습니다.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("애플 스피커 소리는 높인다");		
	}

	@Override
	public void volumeDown() {
		System.out.println("애플 스피커 소리는 낮춘다");
	}

}
