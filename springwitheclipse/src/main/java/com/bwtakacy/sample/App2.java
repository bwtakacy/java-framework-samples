package com.bwtakacy.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app =
				new AnnotationConfigApplicationContext(HelloBeanConfig.class);
		HelloBean bean1 = (HelloBean)app.getBean(HelloBeanNextImpl.class);
		bean1.hello();
	}

}
