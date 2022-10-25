package com.ssafy.ws.model.service;

import java.io.IOException;

import com.ssafy.ws.model.dto.User;

public interface UserService {
	User select(String id) throws Exception;
	User login(User user) throws Exception;
}
