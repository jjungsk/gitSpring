package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.repo.BookRepo;

@Service(value = "bService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo bookRepo;
	
//	public void BookServiceImpl(BookRepo bookRepo) {
//		this.bookRepo = bookRepo;
//	}
	

	@Override
	public int insert(Book book) throws Exception {
		return bookRepo.insert(book);
	}

	@Override
	public int update(Book book) throws Exception {
		return bookRepo.update(book);
	}

	@Override
	public int delete(String booknumber) throws Exception {
		return bookRepo.delete(booknumber);
	}

	@Override
	public Book select(String booknumber) throws Exception {
		return bookRepo.select(booknumber);
	}

	@Override
	public List<Book> search() throws Exception {
		return bookRepo.search();
	}

}
