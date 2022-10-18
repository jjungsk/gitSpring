package com.ssafy.ws.model.repo;

import java.sql.SQLException;

import com.ssafy.ws.dto.User;

public interface UserRepo {
	
	User select(String id) throws SQLException;

}
