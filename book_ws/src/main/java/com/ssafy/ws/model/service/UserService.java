package com.ssafy.ws.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.UserDto;

public interface UserService {

	UserDto login(Map<String, String> map) throws Exception;
	
}
