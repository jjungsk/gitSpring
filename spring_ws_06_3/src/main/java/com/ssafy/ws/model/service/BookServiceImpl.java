package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public int insert(Book book) throws Exception {
		return bookDao.insert(book);
	}

	@Override
	public int update(Book book) throws Exception {
		return bookDao.update(book);
	}

	@Override
	public int delete(String booknumber) throws Exception {
		return bookDao.delete(booknumber);
	}

	@Override
	public Book select(String booknumber) throws Exception {
		return bookDao.select(booknumber);
	}

	@Override
	public List<Book> selectAll() throws Exception {
		System.out.println("ser");
		return bookDao.selectAll();
	}

	

}
