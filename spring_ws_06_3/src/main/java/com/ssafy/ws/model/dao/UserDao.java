package com.ssafy.ws.model.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.ws.model.dto.User;

public interface UserDao {
	User select(String id) throws SQLException;

}
