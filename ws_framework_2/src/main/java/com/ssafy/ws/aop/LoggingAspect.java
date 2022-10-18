package com.ssafy.ws.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {
	
	@Around(value = "execution(* com.ssafy..*.*(..))")
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

}
