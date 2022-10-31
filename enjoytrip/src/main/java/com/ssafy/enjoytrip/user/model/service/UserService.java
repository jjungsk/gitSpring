package com.ssafy.enjoytrip.user.model.service;

import com.ssafy.enjoytrip.user.model.UserDto;

public interface UserService {

	int checkID(String userId) throws Exception;
	
	String findPass(String userId, String userName) throws Exception;

	int joinUser(UserDto userDto) throws Exception;

	UserDto loginUser(String userId) throws Exception;

	int modifyUser(UserDto userDto) throws Exception;

	int deleteUser(String userId) throws Exception;

}
