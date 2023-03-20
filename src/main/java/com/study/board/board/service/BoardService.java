package com.study.board.board.service;

import java.util.List;

import com.study.board.board.vo.BoardVO;
import com.study.board.board.vo.PageVO;
import com.study.board.search.vo.SearchVO;

public interface BoardService {
	//글 목록 조회
	List<BoardVO> getBoardList(PageVO pageVO);
	
	//글 등록
	int regBoard(BoardVO boardVO);
	
	//글 상세 조회
	BoardVO getBoardDetail(String boardNum);
	
	//글 상세 조회시 조회수 증가
	int increaseReadCnt(String boardNum);
	
	//글 삭제
	int deleteBoard(String boarNum);
	
	//글 수정
	int updateBoard(BoardVO boardVO);
	
	//글 개수 조회
	int getBoardCnt(); 
	
}
