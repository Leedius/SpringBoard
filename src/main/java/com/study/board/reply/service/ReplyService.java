package com.study.board.reply.service;

import java.util.List;

import com.study.board.reply.vo.ReplyVO;

public interface ReplyService {
	//댓글 리스트 조회
	List<ReplyVO> getReplyList(String boardNum);
	
	//댓글 등록
	int regReply(ReplyVO replyVO);
	
	//댓글 삭제
	int deleteReply(String replyNum);
	
	//댓글 수정
	int updateReply(ReplyVO replyVO);
}
