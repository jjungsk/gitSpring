package com.ssafy.ws.model.dao;

import java.sql.SQLException;

import com.ssafy.ws.model.dto.User;

public interface UserDao {
	User select(String id) throws SQLException;
	User login(User user) throws SQLException;
}
