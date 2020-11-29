package com.imooc;

import com.imooc.services.WelcomeService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@ComponentScan("com.com.imooc")
public class Entrance {

	/**
	 * 通过XMl文件来初始化IOC
	 */
	public static void main(String[] args) {
		String xmlPath = "G:\\Study_WorkSpace\\Spring\\Spring-Framework-v5.0.6.release\\" +
				"spring-study\\src\\main\\resources\\spring\\Spring-config.xml";

		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");
		System.out.println(welcomeService.sayHello("Hello Spring Source Code"));

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String goal : beanDefinitionNames) {
			System.out.println("--->" + goal);
		}

		Object bean = applicationContext.getBean("userFactoryBean");
		Object bean2 = applicationContext.getBean(BeanFactory.FACTORY_BEAN_PREFIX + "userFactoryBean");
		System.out.println(bean.toString());
		System.out.println(bean2.toString());
	}


	/**
	 * 通过注解来初始化IOC
	 */
	public static void mainAnno(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String goal : beanDefinitionNames) {
			System.out.println("--->" + goal);
		}

		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeServiceImpl");
		welcomeService.sayHello("I am create by annotation");


	}
}
