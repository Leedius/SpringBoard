package com.study.board.member.service;

import com.study.board.member.vo.MemberVO;

public interface MemberService {
	
	//로그인
	MemberVO loginMember(MemberVO memberVO);
	
	//회원가입
	int joinMember(MemberVO memberVO);
	
}
