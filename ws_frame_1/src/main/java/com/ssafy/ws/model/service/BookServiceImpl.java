package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.Book;
import com.ssafy.ws.model.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	private BookRepo bookRepo;
	
	public void setBookRepo(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public int insert(Book book) {
		return bookRepo.insert(book);
	}

	@Override
	public int update(Book book) {
		return bookRepo.update(book);
	}

	@Override
	public int delete(String isbn) {
		return bookRepo.delete(isbn);
	}

	@Override
	public Book select(String isbn) {
		return bookRepo.select(isbn);
	}

	@Override
	public List<Book> search() {
		return bookRepo.search();
	}

}
