package com.bwtakacy.sample;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class HelloBeanConfig {
	private String title = "Hello Bean Impl";
	private String message = "This is AOP Sample.";

	
	@Bean
	public HelloBean helloBean() {
		return new HelloBeanImpl(title, message);
	}
	
	
	@Bean
	SampleAspect sampleAspect() {
		return new SampleAspect();
	}

}
