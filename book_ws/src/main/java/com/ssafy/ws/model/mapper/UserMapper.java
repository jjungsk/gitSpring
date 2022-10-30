package com.ssafy.ws.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.UserDto;

@Mapper
public interface UserMapper {
	
	UserDto login(Map<String, String> map) throws SQLException; // mysql에는 인자값 2개가 안넘어 가므로 Map또는 Dto로 보낸다

}
