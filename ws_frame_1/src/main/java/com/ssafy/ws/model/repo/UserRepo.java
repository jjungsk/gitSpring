package com.ssafy.ws.model.repo;

import com.ssafy.ws.model.User;

public interface UserRepo {

	User select(String id);
}
