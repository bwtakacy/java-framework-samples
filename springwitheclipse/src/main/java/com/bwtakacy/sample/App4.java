package com.bwtakacy.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App4 {
	public static void main(String[] args) {
		ApplicationContext app =
				new AnnotationConfigApplicationContext(HelloBeanConfig.class);
		HelloBean bean1 = (HelloBean)app.getBean("helloBean");
		bean1.hello();
		
	}
}
