package com.bwtakacy.sample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SampleAspect {
	
	@Before("execution(* com.bwtakacy.sample.HelloBean.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("before: [" + jp.getSignature() + "]");
	}
	
	@After("execution(* com.bwtakacy.sample.HelloBean.*(..))")
	public void after(JoinPoint jp) {
		System.out.println("after: [" + jp.getSignature() + "]");
	}

}
