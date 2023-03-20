function isPrivateCheck(isPrivate, boardPw, boardNum){
    if(isPrivate == 'Y'){
        const inputPw = prompt('비밀 번호를 입력하세요', '');
        console.log('inputPw:', inputPw);
        console.log('boardPw:', boardPw);
        if(inputPw != boardPw){
            alert('비밀번호가 일치 하지 않습니다.');
            return false;
        }
    }
    location.href = '/board/boardDetail?boardNum=' + boardNum;
}

// password 입력 창을 생성합니다.
