package com.study.board.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardVO {
	private String boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String regDate;
	private int readCnt;
	private String isPrivate;
	private String boardPw;
	private int replyCnt;
	private int rowNum;
	private int rowNumber;
}
