package com.ssafy.board.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {
	
	@Around(value = "execution(* com.ssafy.board..*.*(..))")
	public Object executeTime(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("executeTime : " + joinPoint.getSignature());
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object proceed = joinPoint.proceed();
		
		stopWatch.stop();
		System.out.println("summary : " + stopWatch.shortSummary());
		System.out.println("totalTime : " + stopWatch.getTotalTimeMillis());
		System.out.println("pretty : " + stopWatch.prettyPrint());
		
		return proceed;
	}
	
	@Before(value = "execution(* com.ssafy.board..*Dao.write*(..))")
	public void logging(JoinPoint joinPoint) {
		System.out.println("before logging : " + joinPoint.getSignature());
		System.out.println("전달인자 : " + joinPoint.getArgs());
	}
//
	@AfterReturning(value = "execution(* com.ssafy.board..*Dao.write*(..))", returning = "obj")
	public void afterReturningMethod(JoinPoint joinPoint, Object obj) {
		System.out.println("afterRetunrningMehod : " + joinPoint.getSignature());
		System.out.println("리턴값 : " + obj);
	}
//	
	@AfterThrowing(value = "execution(* com.ssafy.board..*Dao.write*(..))", throwing = "exception")
	public void afterThrowingMethod(JoinPoint joinPoint, Exception exception) {
		System.out.println("afterThrowingMehod : " + joinPoint.getSignature());
		System.out.println("Exception : " + exception);
	}
	
	@After(value = "execution(* com.ssafy.board..*Dao.write*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		System.out.println("afterMehod : " + joinPoint.getSignature());
	}
	
	
}
