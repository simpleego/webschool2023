package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//@Service
//@Aspect
public class AroundAdvice {
	
	//@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	//@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().getName();
		
		// 시계 스톱와치 시작설정
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();		
		
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();	
		
		System.out.println(method+"()메서드 수행에 걸린시간 : "+
		        stopWatch.getTotalTimeMillis()+"(ms)초");		
		
		// 시계 스톱와치 끝 설정
		return returnObj;
	}
	
}
