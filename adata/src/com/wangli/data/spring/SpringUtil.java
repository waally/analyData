package com.wangli.data.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @ClassName SpringUtil
 * @Description Spring工具类
 * @author wangli
 * @date 2014-8-4 下午6:38:55
 */
public class SpringUtil {

	private static ApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static ApplicationContext getSpringContext() {
		return springContext;
	}
	
}
