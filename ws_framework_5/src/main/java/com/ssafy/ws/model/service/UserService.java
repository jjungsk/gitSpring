package com.ssafy.ws.model.service;

import java.util.Map;

import com.ssafy.ws.model.dto.User;

public interface UserService {
	
	User select(String id) throws Exception;
	User login(Map<String, String> map) throws Exception; // 로그인

}
