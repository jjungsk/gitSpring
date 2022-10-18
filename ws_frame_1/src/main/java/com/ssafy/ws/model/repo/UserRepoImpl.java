package com.ssafy.ws.model.repo;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.User;

@Repository
public class UserRepoImpl implements UserRepo {

	private DataSource dataSource;
	
	public UserRepoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public User select(String id) {
		System.out.println("아이디 검색!!");
		return null;
	}

}
