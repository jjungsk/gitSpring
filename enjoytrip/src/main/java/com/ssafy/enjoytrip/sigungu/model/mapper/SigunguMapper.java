package com.ssafy.enjoytrip.sigungu.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.sigungu.model.SigunguDto;

@Mapper
public interface SigunguMapper {
	
	List<SigunguDto> list(int areaCode) throws SQLException;
}
