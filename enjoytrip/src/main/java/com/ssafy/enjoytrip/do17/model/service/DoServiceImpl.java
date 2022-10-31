package com.ssafy.enjoytrip.do17.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.do17.model.DoDto;
import com.ssafy.enjoytrip.do17.model.mapper.DoMapper;

@Service
public class DoServiceImpl implements DoService {

	private DoMapper doMapper;
	
	private DoServiceImpl(DoMapper doMapper) {
		this.doMapper = doMapper;
	}
	
	@Override
	public List<DoDto> list() throws Exception {
		return doMapper.list();
	}

}
