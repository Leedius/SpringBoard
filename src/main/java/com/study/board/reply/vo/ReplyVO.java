package com.study.board.reply.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	private String replyNum;
	private String replyContent;
	private String replyWriter;
	private String regDate;
	private String boardNum;
}
