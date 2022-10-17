package com.ssafy.ws.model.service;

import com.ssafy.ws.model.User;
import com.ssafy.ws.model.repo.UserRepo;

public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User select(String id) throws Exception {
		return userRepo.select(id);
	}

}
