package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.Book;
import com.ssafy.ws.model.repo.BookRepo;

public class BookServiceImpl implements BookService {
	
	private BookRepo bookRepo;
	
	public void setBookRepo(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public BookRepo getBookRepo() {
		return bookRepo;
	}

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
