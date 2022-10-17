package com.ssafy.ws.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.model.Book;

public interface BookRepo {
	
	int insert(Book book) throws SQLException;
	int update(Book book) throws SQLException;
	int delete(String booknumber) throws SQLException;
	Book select(String booknumber) throws SQLException;
	List<Book> search() throws SQLException;

}
