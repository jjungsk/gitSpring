package com.ssafy.ws.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.BookDto;

@Mapper
public interface BookMapper {
	
	List<BookDto> listBook() throws SQLException;
	void registerBook(BookDto bookDto) throws SQLException;
	BookDto getBook(String isbn) throws SQLException;
	void modifyBook(BookDto bookDto) throws SQLException;
	void deleteBook(String isbn) throws SQLException;

}
