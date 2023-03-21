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


//댓글 수정창 띄우기
function toggle(replyNum){
	//모든 댓글 요소를 가져오기
	const allReply = document.querySelectorAll('.reply_loop_wrap');
	
	//모든 댓글 요소를 반복
	for(const e of allReply){
		//가져온 댓글 넘버와 같은지 확인
		if(e.querySelector('#nReply').value == replyNum){
			//가져온 댓글 넘버와 같으면 댓글내용들 숨기기
			e.querySelector('.reply_loop').style.display = 'none';
			//댓글 수정 입력창 띄우기
			e.querySelector('.update_reg_reply').style.display = 'block';
		}
	}
};

//댓글 수정창 다른 방법
//자바 스크립트 pdf 노드 추가 삭제 부분 참조
function setInput(selectedTag, replyNum, boardNum) {
	//수정 버튼 클릭시
	if (selectedTag.value == '수정') {
		//클릭한 수정버튼에서 댓글 내용이 있는 태그르 찾아가기.
		//참고 previousElementSibling부모태그의 이전태그
		const contentDiv = (selectedTag.parentElement).parentElement.previousElementSibling.previousElementSibling;
		//const contentDiv = ((selectedTag.parentElement).parentElement).parentElement;

		//선택한 태그 삭제
		//contentDiv.remove();

		//댓글 내용을 저장
		const content = contentDiv.textContent;

		//선택한 태그 안의 내용 비우기
		contentDiv.innerHTML = '';

		//태그에 INPUT태그를 추가
		let str = ``;
		str += '<form id="updateReplyForm" action="/reply/updateReply" method="post">';
		str += `<input type="hidden" value="${replyNum}" name="replyNum">`;
		str += `<input type="hidden" value="${boardNum}" name="boardNum">`;
		str += `<input type="text" value="${content}" name="replyContent">`;
		str += '</form>'
		
		//태그에 input태그를 추가
		//타임리프 문법은 해석안됨.
		//let distr =``;
		//distr += `<th:block th:if="${(session.loginInfo != null && session.loginInfo.memId == reply.replyWriter) || (session.loginInfo != null && session.loginInfo.isAdmin == 'Y') }">`;
		//distr += '<div class="update_reply_box">';
		//distr += '<div class="update_reg_reply">';
		//distr += `<div class="reg_reply_writer">[[${session.loginInfo.memId}]]`;						
		//distr += '</div>'									
		//distr += `<form th:action="@{/reply/updateReply(boardNum=${boardDetail.boardNum})}" method="post">`;							
		//distr += `<input type="hidden" name="replyNum" th:value="${reply.replyNum}">`;								
		//distr += `<textarea rows="1" class="update_reply_content" th:name="replyContent" th:text="${reply.replyContent}" oninput="resize(this)" required></textarea>`;							
		//distr += `<div class="reg_reply_btn" style="margin-bottom:0;">`;									
		//distr += '<input class="r_btn" type="submit" value="등록">';									
		//distr += `<input class="r_btn" type="button" value="취소" th:onclick="updateReplyCancel([[${reply.replyNum}]])">`;											
		//distr += '</div>';									
		//distr += '</form>';										
		//distr += '</div>';									
		//distr += '</div>';								
		//distr += '</th:block>';							
								

		//선택한 태그의 첫번째 자식 태그로 삽입
		contentDiv.insertAdjacentHTML('afterbegin', str);

		//수정 버튼의 글자를 변경
		selectedTag.value = '확인';
	}
	else {
		//form태그를 submit 시킨다
		document.querySelector('#updateReplyForm').submit();
	}

}

//댓글 수정 취소
function updateReplyCancel(replyNum){
	//열려 있는 댓글 수정 박스
	
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

