package com.bwtakacy.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext app =
				new ClassPathXmlApplicationContext("bean-conf.xml");
		ExternalBean bean1 = (ExternalBean)app.getBean("externalbean");
		bean1.sayHello();
	}

}
