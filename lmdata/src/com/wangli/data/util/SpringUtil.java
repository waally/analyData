package com.wangli.data.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	private static ApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static ApplicationContext getSpringContext() {
		return springContext;
	}
	
}
