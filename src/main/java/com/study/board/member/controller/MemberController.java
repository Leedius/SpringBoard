package com.study.board.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.board.member.service.MemberService;
import com.study.board.member.vo.MemberVO;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;

//어노테이션 사용하여 컨트롤러 객체 생성
@Controller
@RequestMapping("/member")
public class MemberController {
	//프로젝트 생성 시 바로 만들어진 memberService라는 객체를 
	//의존성 주입 시키겠다~
	@Resource(name = "memberService")
	private MemberService memberService;
	
	//로그인 페이지로 이동
	@GetMapping("/login")	//locahost:8081/member/login
	public String goLogin(MemberVO memberVO) {
		return "content/member/login_form";
	}
	
	//로그인 정보를 가지고 로그인 결과 페이지로 이동
	@PostMapping("/login")
	public String loginForm(MemberVO memberVO, HttpSession session) {
		MemberVO loginInfo = memberService.loginMember(memberVO);
		//로그인 체크
		//로그인 성공
		if(loginInfo != null) {
			//세션 객체 생성
			//위의 매개변수로 넣어서 자동으로 객체 생성
			//세션에 로그인 정보 저장
			session.setAttribute("loginInfo", loginInfo);
		}
		return "content/member/login_result";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션에서 정보 삭제
		session.removeAttribute("loginInfo");
		return "redirect:/board/boardList";
	}
	
	//회원 가입 페이지로 이동
	@GetMapping("/goJoin")
	public String goJoin(MemberVO memberVO) {
		return "content/member/join_form";
	}
	
	//회원 가입후 로그인 페이지로 이동
	@PostMapping("/joinMember")
	public String joinMember(MemberVO memberVO) {
		memberService.joinMember(memberVO);
		return "content/member/login_form";
	}
	
}
