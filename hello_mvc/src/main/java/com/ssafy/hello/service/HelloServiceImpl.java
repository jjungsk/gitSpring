package com.ssafy.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hello.dao.HelloDao;

@Service
public class HelloServiceImpl implements HelloService {
	
	@Autowired
	private HelloDao helloDao;

	@Override
	public String hello() {
		
		return helloDao.Hello();
	}

}
