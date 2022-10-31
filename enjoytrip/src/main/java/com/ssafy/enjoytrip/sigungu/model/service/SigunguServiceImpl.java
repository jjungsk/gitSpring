package com.ssafy.enjoytrip.sigungu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.sigungu.model.SigunguDto;
import com.ssafy.enjoytrip.sigungu.model.mapper.SigunguMapper;

@Service
public class SigunguServiceImpl implements SigunguService {
	
	private SigunguMapper sigunguMapper;
	
	@Autowired
	private SigunguServiceImpl(SigunguMapper sigunguMapper) {
		this.sigunguMapper = sigunguMapper;
	}
	
	@Override
	public List<SigunguDto> list(int areaCode) throws Exception {
		return sigunguMapper.list(areaCode);
	}

}
