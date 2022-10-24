package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;

public interface BookDao {

	int insert(Book book);

	Book select(String isbn);
	
	/**
	 * 조건에 맞는 데이터의 목록을 반환한다.
	 * @param condition
	 * @return
	 */
	List<Book> search(SearchCondition condition);
	
	/**
	 * 조건에 맞는 데이터의 건수를 반환한다.
	 * @param condition
	 * @return
	 */
	int getTotalSearchCount(SearchCondition condition);
}
