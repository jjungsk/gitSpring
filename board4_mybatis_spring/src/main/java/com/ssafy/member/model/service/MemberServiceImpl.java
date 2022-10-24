package com.ssafy.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memeberMapper;
	
	@Autowired
	private MemberServiceImpl(MemberMapper memberDao) {
		this.memeberMapper = memberDao;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return memeberMapper.idCheck(userId);
	}

	@Override
	public void joinMember(MemberDto memberDto) throws Exception {
		memeberMapper.joinMember(memberDto);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) throws Exception {
		return memeberMapper.loginMember(map);
	}

}
