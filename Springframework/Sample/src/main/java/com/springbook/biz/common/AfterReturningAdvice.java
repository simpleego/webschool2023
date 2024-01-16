package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterReturningLog(JoinPoint jp, Object retrunObj) {
		String method = jp.getSignature().getName();
		if(retrunObj instanceof UserVO) {
			UserVO user = (UserVO) retrunObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName()+"로그인(관리자)");
			}
		}		
		System.out.println("[사후 처리]"+method+"() 메서드 리턴값:"+retrunObj.toString());
	}
}
