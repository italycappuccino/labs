/**
 * @Project: edu
 * @Author: Peter
 * @Date: 2014年8月30日
 * www.italycappuccino.com italycappuccino@gmail.com
 * 
 * @Copyright: 3Stock Inc. All rights reserved.
 */
package com.stone.core.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Peter
 * @create 2014年8月30日
 */
@Configuration
@ComponentScan
public class Application {
	
	@Bean
	MessageService mockMessageService(){
		return new MessageService() {
			
			@Override
			public String getMessage() {
				return "hello,peter";
			}
		};
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}

}
