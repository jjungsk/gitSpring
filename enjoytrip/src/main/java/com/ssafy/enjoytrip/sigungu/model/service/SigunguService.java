package com.ssafy.enjoytrip.sigungu.model.service;

import java.util.List;

import com.ssafy.enjoytrip.sigungu.model.SigunguDto;

public interface SigunguService {
	
	List<SigunguDto> list(int areaCode) throws Exception;
}
