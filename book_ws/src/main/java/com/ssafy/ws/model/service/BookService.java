package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.BookDto;

public interface BookService {
	
	List<BookDto> listBook() throws Exception;
	void registerBook(BookDto bookDto) throws Exception;
	BookDto getBook(String isbn) throws Exception;
	void modifyBook(BookDto bookDto) throws Exception;
	void deleteBook(String isbn) throws Exception;
	
}
