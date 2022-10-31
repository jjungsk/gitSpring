package com.ssafy.enjoytrip.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	@Autowired
	private UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int checkID(String userId) throws Exception {
		return userMapper.checkID(userId);
	}

	@Override
	public String findPass(String userId, String userName) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findPass(userId, userName);
	}

	@Override
	public int joinUser(UserDto userDto) throws Exception {
		return userMapper.joinUser(userDto);
	}

	@Override
	public UserDto loginUser(String userId) throws Exception {
		return userMapper.loginUser(userId);
	}

	@Override
	public int modifyUser(UserDto userDto) throws Exception {
		return userMapper.modifyUser(userDto);
	}

	@Override
	public int deleteUser(String userId) throws Exception {
		return userMapper.deleteUser(userId);
	}

}
