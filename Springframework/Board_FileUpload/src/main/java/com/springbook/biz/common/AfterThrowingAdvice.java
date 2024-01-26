package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void  execeptionLog(JoinPoint jp, Exception execeptObj) {
		String method = jp.getSignature().getName();
		System.out.println("예외 종류 :"+execeptObj.getMessage());
		System.out.println("[예외처리]"+method+"()메서드 수행 중 예외 발생");
	}
}
