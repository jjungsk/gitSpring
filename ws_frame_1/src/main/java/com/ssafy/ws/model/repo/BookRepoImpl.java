package com.ssafy.ws.model.repo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.Book;

@Repository
public class BookRepoImpl implements BookRepo {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int insert(Book book) {
		System.out.println("책 등록!!");
		return 0;
	}

	@Override
	public int update(Book book) {
		System.out.println("책 수정!!");
		return 0;
	}

	@Override
	public int delete(String isbn) {
		System.out.println("책 삭제!!");
		return 0;
	}

	@Override
	public Book select(String isbn) {
		System.out.println("책 검색!!");
		return null;
	}

	@Override
	public List<Book> search() {
		System.out.println("책 목록!!");
		return null;
	}

}
