package com.ssafy.ws.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;

public interface BookService {
	int insert(Book book) throws IllegalStateException, IOException;

	Book select(String isbn);

	// 동적 쿼리를 이용해 다양한 검색 옵션을 적용할 수 있도록 search를 변경한다.
	List<Book> search(SearchCondition condition);
	
	/**
	 * 리스트에 페이징을 적용하기 위한 메서드
	 * Map에 books를 키로 화면에 표시할 Book 목록을 저장하고
	 * navigation이라는 키로 PageNavigation 객체를 저장해서 반환한다.
	 * PageNavigation을 만들기 위한 정보로 currentPage는 SearchCondition에서 얻어오고
	 * totalCount는 BookRepo에 새롭게 추가한 메서드를 사용한다.
	 * @param condition
	 * @return
	 */
	Map<String, Object> pagingSearch(SearchCondition condition);
}
