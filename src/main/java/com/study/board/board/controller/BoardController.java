package com.study.board.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.board.board.service.BoardService;
import com.study.board.board.vo.BoardVO;
import com.study.board.board.vo.PageVO;
import com.study.board.member.vo.MemberVO;
import com.study.board.reply.service.ReplyService;
import com.study.board.reply.vo.ReplyVO;
import com.study.board.search.vo.SearchVO;

import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;

//어노테이션 사용하여 컨트롤러 객체 생성
@Controller
@RequestMapping("/board")
public class BoardController {
	//프로젝트 생성 시 바로 만들어진 memberService라는 객체를 
	//의존성 주입 시키겠다~
	@Resource(name = "boardService")
	private BoardService boardService;
	//댓글 목록 조회를 하기 위해서 만들어진 replySerivce라는 객체를
	//replyService에 의존성 주입
	@Resource(name = "replyService")
	private ReplyService replyService;
	
	//글 목록 페이지로 이동
	@GetMapping("/boardList")
	public String boardList(SearchVO searchVO, Model model, PageVO pageVO, HttpSession session) {
		//페이징 정보 세팅
		//글 개수 데이터 저장
		System.out.println("글갯수 : " + boardService.getBoardCnt());
		int totalDataCnt = boardService.getBoardCnt();
		pageVO.setTotalDataCnt(totalDataCnt);
		pageVO.setPageInfo();
		
		//게시글 목록 데이터 전달
		model.addAttribute("boardList", boardService.getBoardList(pageVO));
		
		//조회수 증가에서 저장된 세션 삭제
		String sessionKey = "boardReadCheck";
		session.removeAttribute(sessionKey);
		
		return "content/board/board_list";
	}
	
	/*
	 * //글 목록 페이지로 이동(검색)
	 * 
	 * @PostMapping("/boardList") public String searchBoardList(SearchVO searchVO,
	 * Model model) { System.out.println(searchVO); model.addAttribute("boardList",
	 * boardService.getBoardList()); return "content/board/board_list"; }
	 */
	
	//글 등록 페이지로 이동
	@GetMapping("/goWriteBoardForm")
	public String goWriteBoardForm(BoardVO boardVO) {
		return "content/board/board_write_form";
	}
	
	//글 등록
	@PostMapping("/regBoard")
	public String regBoard(BoardVO boardVO, String boardWriter, HttpSession session) {
		
		//비밀글 체크 안했을때 했을때 값 넣기
		boardVO.setIsPrivate(boardVO.getIsPrivate() == null ? "N" : "Y");		
		MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
		boardVO.setBoardWriter(loginInfo.getMemId());
		boardService.regBoard(boardVO);
		return "redirect:/board/boardList";
	}
	
	//글 상세보기(댓글목록도 같이 조회)
	@GetMapping("/boardDetail")
	public String boardDetail(String boardNum, Model model, HttpSession session, ReplyVO replyVO) {
	    String sessionKey = "boardReadCheck";
	    // boardReadCheck 세션값이 없으면 조회수 증가 후 세션값 설정
	    if (session.getAttribute(sessionKey) == null) {
	        boardService.increaseReadCnt(boardNum);
	        session.setAttribute(sessionKey, true);
	    }
	    
	    model.addAttribute("replyList", replyService.getReplyList(boardNum));
	    model.addAttribute("boardDetail", boardService.getBoardDetail(boardNum));
	    return "content/board/board_detail";
	}
	
	//글 수정 페이지로 이동
	@GetMapping("/goUpdateBoardForm")
	public String updateBoardForm(String boardNum, Model model) {
		model.addAttribute("boardDetail", boardService.getBoardDetail(boardNum)); 
		return "content/board/update_board_form";
	}
	
	//글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return "redirect:/board/boardDetail?boardNum=" + boardVO.getBoardNum();
	}
	
	//글 삭제
	@GetMapping("/goDeleteBoard")
	public String deleteBoard(String boardNum) {
		boardService.deleteBoard(boardNum);
		return "redirect:/board/boardList";
	}
	
	//fragment 사용 시 외부 css, js 연결 테스트
	@GetMapping("/test2")
	public String test2() {
		return "content/board/test_fragment";
	}
	
}
