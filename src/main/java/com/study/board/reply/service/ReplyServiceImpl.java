package com.study.board.reply.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.reply.vo.ReplyVO;

//객체를 만들어 주는 어노테이션
//MemberServiceImpl memberService = new MemberServiceImpl();
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	//프로젝트 생성 시 Mybatis를 쓰겠다고 등록하면
	//내부적으로 아래와 같은 객체를 하나 만들어준다
	//SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate();
	//db관련 기능 사용할 sqlSession 객체 생성(DI : 의존성)
	@Autowired
	SqlSessionTemplate sqlSession;

	//해당 글 댓글 리스트 조회
	@Override
	public List<ReplyVO> getReplyList(String boardNum) {
		return sqlSession.selectList("replyMapper.getReplyList", boardNum);
	}
	
	//댓글 등록
	@Override
	public int regReply(ReplyVO replyVO) {
		return sqlSession.insert("replyMapper.regReply", replyVO);
	}

	//댓글 삭제
	@Override
	public int deleteReply(String replyNum) {
		return sqlSession.delete("replyMapper.deleteReply", replyNum);
	}

	//댓글 수정
	@Override
	public int updateReply(ReplyVO replyVO) {
		return sqlSession.update("replyMapper.updateReply", replyVO);
	}

}
