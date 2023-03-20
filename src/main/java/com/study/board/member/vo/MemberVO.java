package com.study.board.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String isAdmin;
}
