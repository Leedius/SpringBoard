function togglePw(){
	//작성된 비밀번호 지워주기
	document.querySelector('#boardPw').value = '';
	const inputBoardPW = document.querySelector('#input_board_pw');
	
	//()라는 클래스를 추가, 삭제
	inputBoardPW.classList.toggle('input_board_pw');
	
	const isPrivate = document.getElementById('isPrivate');
	isPrivate.addEventListener('change' , function(){
	if (isPrivate.checked) {
		isPrivate.value = 'Y';
	} else {
		isPrivate.value = 'N';
	} 
	
	})
};


//-------------------------다른방법1-----------------------------
/* function togglePw(){
	//체크박스
	const checkbox = document.querySelector('#isPrivate');
	//체크 박스 체크 여부
	const isChecked = checkbox.checked;
	
	//체크 됐을 때.
	if(isChecked){
		const inputBoardPW = document.querySelector('#input_board_pw');
		//글 비밀번호 입력하는 인풋박스 숨기기 해제
		//()해당 클래스를 제거
		inputBoardPW.classList.remove('input_board_pw');
		checkbox.value = 'Y';
	}	
	else {
		const inputBoardPW = document.querySelector('#input_board_pw')
		let boardPw = document.querySelector('#boardPw');
		//글 비밀번호 입력하는 인풋박스 숨기기 해제
		//()클래스를 추가
		inputBoardPW.classList.add('input_board_pw');
		boardPw.value = null;
		checkbox.value = 'N';
	}
}; */

//-------------------------다른방법2-----------------------------

/* let isPrivateCheckbox = document.querySelector('#isPrivate');
let isPrivateHiddenInput = document.querySelector('#isPrivateHidden');

isPrivateCheckbox.addEventListener('change', function() {
  if (isPrivateCheckbox.checked) {
    isPrivateHiddenInput.disabled = true;
    isPrivateHiddenInput.value = '';
  } else {
    isPrivateHiddenInput.disabled = false;
    isPrivateHiddenInput.value = 'N';
  }
});

//페이지 로드 시 체크박스의 초기 상태에 따라 isPrivateHidden 값을 설정합니다.
if (isPrivateCheckbox.checked) {
  isPrivateHiddenInput.disabled = true;
  isPrivateHiddenInput.value = '';
} else {
  isPrivateHiddenInput.disabled = false;
  isPrivateHiddenInput.value = 'N';
}

const checkbox = document.getElementById('isPrivate');
const passwordInput = document.querySelector('.input_board_pw');
let boardPw = document.getElementById('boardPw');

	checkbox.addEventListener('change', function() {
	    if (checkbox.checked) {
	        passwordInput.style.visibility = 'visible';
	    } else {
	    	boardPw.value = null;
	        passwordInput.style.visibility = 'hidden';
	    }
	}); */
