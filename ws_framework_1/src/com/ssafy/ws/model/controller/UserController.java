package com.ssafy.ws.model.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.model.User;
import com.ssafy.ws.model.service.UserService;
import com.ssafy.ws.model.service.UserServiceImpl;

public class UserController {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// xml or annotaion의 spring 설정 읽어오기
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/ssafy/ws/model/config/application.xml");
		
		UserService userService = context.getBean("userService", UserServiceImpl.class);
		System.out.println("ID 입력 : ");
		String id = br.readLine();
		
		try {
			userService.select(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
