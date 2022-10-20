package com.ssafy.ws.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User select(String id) throws Exception {
		return userRepo.select(id);
	}

	@Override
	public User login(Map<String, String> map) throws Exception {
		return userRepo.login(map);
	}

}
