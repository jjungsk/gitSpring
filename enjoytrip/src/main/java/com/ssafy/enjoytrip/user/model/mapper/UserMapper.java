package com.ssafy.enjoytrip.user.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.user.model.UserDto;

@Mapper
public interface UserMapper {
	
	int checkID(String userId) throws SQLException;

	String findPass(String userId, String userName) throws SQLException;

	int joinUser(UserDto userDto) throws SQLException;

	UserDto loginUser(String userId) throws SQLException;

	int modifyUser(UserDto userDto) throws SQLException;

	int deleteUser(String userId) throws SQLException;

}
