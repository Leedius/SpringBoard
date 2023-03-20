function goBoardUpdate(boardNum) {
	location.href = '/board/goUpdateBoardForm?boardNum='+boardNum;
}
function goBoardDelete(boardNum) {
	if(!confirm('삭제하시면 복구할 수 없습니다. \n 정말로 삭제하시겠습니까??')){
		return false;
	}
	location.href = '/board/goDeleteBoard?boardNum='+boardNum;
}
function goReplyDelete(replyNum, boardNum) {
	if(!confirm('삭제하시면 복구할 수 없습니다. \n 정말로 삭제하시겠습니까??')){
		return false;
	}
	location.href = '/reply/deleteReply?replyNum=' + replyNum + '&boardNum=' + boardNum;
}
function resize(textarea) {
	 textarea.style.height = "auto";
	 textarea.style.height = textarea.scrollHeight + "px";
}


//댓글 수정
function toggle(replyNum){
	//모든 댓글 요소를 가져오기
	const allReply = document.querySelectorAll('.reply_loop_wrap');
	
	for(const e of allReply){
		if(e.querySelector('#nReply').value == replyNum){
			e.querySelector('.reply_loop').style.display = 'none';
			e.querySelector('.update_reg_reply').style.display = 'block';
		}
	}
	
};

//댓글 수정 취소
function updateReplyCancel(replyNum){
	//열려 있는 댓글 수정 박스
	const replyContentView = document.querySelector('.reg_reply');
	
	//모든 댓글 요소를 가져오기
	const allReply = document.querySelectorAll('.reply_loop_wrap');
	
	//수정하고 있는 댓글 찾아서 숨겨져있던 댓글 내용 보이기
	for(const e of allReply){
		if(e.querySelector('#nReply').value == replyNum){
			e.querySelector('.reply_loop').style.display = 'block';
			//댓글 수정 박스 숨기기
			e.querySelector('.update_reg_reply').style.display = 'none';
		}
	}
}

