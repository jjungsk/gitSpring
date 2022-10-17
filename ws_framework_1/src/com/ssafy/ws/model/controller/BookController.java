package com.ssafy.ws.model.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.model.Book;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;

public class BookController {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// xml or annotaion의 spring 설정
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/ws/model/config/application.xml");
		
		BookService bookService = context.getBean("bookService", BookServiceImpl.class);
		Book book = new Book();
		System.out.println("책 번호");
		book.setBooknumber(br.readLine());
		System.out.println("책 제목 : ");
		book.setBooktitle(br.readLine());
		System.out.println("저자 : ");
		book.setAuthor(br.readLine());
		System.out.println("책 설명 : ");
		book.setDescription(br.readLine());
		System.out.println("가격 : ");
		book.setPrice(Integer.parseInt(br.readLine()));
		
		try {
			bookService.insert(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
