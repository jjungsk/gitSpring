package com.ssafy.ws.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.model.dto.Book;


public interface BookDao {

	int insert(Book book) throws SQLException;
	int update(Book book) throws SQLException;
	int delete(String isbn) throws SQLException;
	Book select(String isbn) throws SQLException;
	List<Book> selectAll() throws SQLException;

}
