package com.ssafy.member.model.service;

import java.util.List;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	int idCheck(String userId) throws Exception; // 아이디 중복검사
	void joinMember(MemberDto memberDto) throws Exception; // 회원가입
	MemberDto loginMember(String userId, String userPwd) throws Exception; // 로그인
	
	List<MemberDto> listMember() throws Exception; // 회원목록
	
}
