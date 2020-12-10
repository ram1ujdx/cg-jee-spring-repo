package com.cg.spring.mobileapp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Mobile m=context.getBean("mobile",Mobile.class);
		
		m.browse();
		m.makeCall();
		//m.showSupportedNetworks();

	}

}
