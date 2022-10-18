package com.ssafy.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.repo.UserRepo;

@Service(value = "uService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
//	@Autowired
//	public UserServiceImpl(UserRepo userRepo) {
//		this.userRepo = userRepo;
//	}

	@Override
	public User select(String id) throws Exception {
		return userRepo.select(id);
	}

}
