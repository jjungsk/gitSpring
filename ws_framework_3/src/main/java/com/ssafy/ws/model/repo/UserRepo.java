package com.ssafy.ws.model.repo;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.ws.model.dto.User;

public interface UserRepo {
	
	User select(String id) throws SQLException;
	User login(Map<String, String> map) throws SQLException; // 로그인

}
