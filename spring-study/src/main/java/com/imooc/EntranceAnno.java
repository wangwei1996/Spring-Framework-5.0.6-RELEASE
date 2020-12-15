package com.imooc;

import com.imooc.controller.WelcomeController;
import com.imooc.services.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.imooc")
public class EntranceAnno {
	/**
	 * 通过注解来初始化IOC
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EntranceAnno.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String goal : beanDefinitionNames) {
			System.out.println("--->" + goal);
		}

		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeServiceImpl");
		WelcomeController welcomeController = applicationContext.getBean(WelcomeController.class);

		welcomeService.sayHello("I am create by annotation");

	}
}