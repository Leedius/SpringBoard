package com.study.board.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.board.member.vo.MemberVO;
import com.study.board.reply.service.ReplyService;
import com.study.board.reply.vo.ReplyVO;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;

//어노테이션 사용하여 컨트롤러 객체 생성
@Controller
@RequestMapping("/reply")
public class ReplyController {
	//프로젝트 생성 시 바로 만들어진 memberService라는 객체를 
	//의존성 주입 시키겠다~
	@Resource(name = "replyService")
	private ReplyService replyService;
	
	//댓글 등록
	@PostMapping("/regReply")
	public String regReply(ReplyVO replyVO, String boardNum, HttpSession session, Model model) {
		//세션 정보 저장
		MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
		
		//추가 데이터들 객체에 저장
		replyVO.setReplyWriter(loginInfo.getMemId());
		replyVO.setBoardNum(boardNum);
		
		//댓글 등록 쿼리 실행
		replyService.regReply(replyVO);
		
		
		return "redirect:/board/boardDetail?boardNum=" + boardNum;
	}
	
	//댓글 삭제
	@GetMapping("/deleteReply")
	public String deleteReply(String replyNum, String boardNum, Model model) {
		
		//댓글 삭제 쿼리 실행
		replyService.deleteReply(replyNum);
		
		//글 번호 데이터 전달
		model.addAttribute(boardNum);
		
		return "redirect:/board/boardDetail?boardNum=" + boardNum;
	}
	
	//댓글 수정
	@PostMapping("/updateReply")
	public String updateReply(ReplyVO replyVO) {
		replyService.updateReply(replyVO);
		return "redirect:/board/boardDetail?boardNum=" + replyVO.getBoardNum();
	}
	
}
