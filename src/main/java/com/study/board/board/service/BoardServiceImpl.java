package com.study.board.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.board.vo.BoardVO;
import com.study.board.board.vo.PageVO;
import com.study.board.search.vo.SearchVO;

//객체를 만들어 주는 어노테이션
//MemberServiceImpl memberService = new MemberServiceImpl();
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	//프로젝트 생성 시 Mybatis를 쓰겠다고 등록하면
	//내부적으로 아래와 같은 객체를 하나 만들어준다
	//SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate();
	//db관련 기능 사용할 sqlSession 객체 생성(DI : 의존성)
	@Autowired
	private SqlSessionTemplate sqlSession;
	//게시글 목록 조회
	@Override
	public List<BoardVO> getBoardList(PageVO pageVO) {
		return sqlSession.selectList("boardMapper.getBoardList", pageVO);
	}

	//글 등록
	@Override
	public int regBoard(BoardVO boardVO) {
		return sqlSession.insert("boardMapper.regBoard", boardVO);
	}

	//글 상세 조회
	@Override
	public BoardVO getBoardDetail(String boardNum) {
		return sqlSession.selectOne("boardMapper.getBoardDetail", boardNum);
	}

	//글 상세 조회시 조회수 증가
	@Override
	public int increaseReadCnt(String boardNum) {
		return sqlSession.update("boardMapper.increaseReadCnt", boardNum);
	}

	//글 삭제
	@Override
	public int deleteBoard(String boarNum) {
		return sqlSession.delete("boardMapper.deleteBoard", boarNum);
	}

	//글 수정
	@Override
	public int updateBoard(BoardVO boardVO) {
		return sqlSession.update("boardMapper.updateBoard", boardVO);
	}

	//글 개수 조회
	@Override
	public int getBoardCnt() {
		return sqlSession.selectOne("boardMapper.getBoardCnt");
	}
	
}