package com.study.board.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.member.vo.MemberVO;

//객체를 만들어 주는 어노테이션
//MemberServiceImpl memberService = new MemberServiceImpl();
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	//프로젝트 생성 시 Mybatis를 쓰겠다고 등록하면
	//내부적으로 아래와 같은 객체를 하나 만들어준다
	//SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate();
	//db관련 기능 사용할 sqlSession 객체 생성(DI : 의존성)
	@Autowired
	SqlSessionTemplate sqlSession;

	//로그인 기능
	@Override
	public MemberVO loginMember(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.loginMember", memberVO);
	}
	
	//회원가입 기능
	@Override
	public int joinMember(MemberVO memberVO) {
		return sqlSession.insert("memberMapper.joinMember", memberVO);
	}
}
