package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;
import com.ssafy.ws.model.service.UserServiceImpl;

public class WorkshopTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		UserService userService = context.getBean("uService", UserServiceImpl.class);
		userService.select("ssafy");
		BookService bookService = context.getBean("bService", BookServiceImpl.class);
//		bookService.insert("");
//		bookService.update("");
		bookService.delete("");
		bookService.select("");
		bookService.search();
	}
}
