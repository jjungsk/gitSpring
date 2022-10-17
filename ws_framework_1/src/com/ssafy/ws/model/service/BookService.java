package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.Book;

public interface BookService {
	
	int insert(Book book) throws Exception;
	int update(Book book) throws Exception;
	int delete(String booknumber) throws Exception;
	Book select(String booknumber) throws Exception;
	List<Book> search() throws Exception;

}
