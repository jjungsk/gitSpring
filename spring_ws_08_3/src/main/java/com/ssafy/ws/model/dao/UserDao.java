package com.ssafy.ws.model.dao;

<<<<<<< HEAD
import java.sql.SQLException;

import com.ssafy.ws.model.dto.User;

public interface UserDao {
	User select(String id) throws SQLException;
	User login(User user) throws SQLException;
=======
import com.ssafy.ws.model.dto.User;

public interface UserDao {
	User select(String id);
>>>>>>> 8898bdd4d1b0d441d306d528d6831f01c6905c75
}
