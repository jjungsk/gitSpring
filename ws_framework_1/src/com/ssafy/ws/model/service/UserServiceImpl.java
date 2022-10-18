package com.ssafy.ws.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.User;
import com.ssafy.ws.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User select(String id) throws Exception {
		return userRepo.select(id);
	}

}
