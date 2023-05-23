/**
 * reply.js
 * 댓글 등록, 목록 검색, 수정, 삭제
 * /post/detail.jsp에 포함
 */

document.addEventListener("DOMContentLoaded", () => {
    // 부트스트랩 Collapse 객체를 생성 - 초기 상태는 화면에서 안보이는 상태(접힌 상태)
    const bsCollapse = new bootstrap.Collapse('div#replyToggleDiv', {toggle: false});
    
    // 댓글 등록/목록숨기기/보이기/ 토글 버튼에 이벤트 리스너를 등록
    const btnToggleReply = document.querySelector('#btnToggleReply');
    btnToggleReply.addEventListener('click', () => {
        bsCollapse.toggle();
        
        const toggle = btnToggleReply.getAttribute('data-toggle');
        
        if (toggle === 'toggle-off') {
            btnToggleReply.innerHTML = 'off';
            btnToggleReply.setAttribute('data-toggle','toggle-on');
        } else {
            btnToggleReply.innerHTML = 'on';
            btnToggleReply.setAttribute('data-toggle','toggle-off');
        }
    });
    
    const btnAddReply = document.querySelector('button#btnAddReply');
    const createReply = (e) => {
        const postId = document.querySelector('input#id').value;
        const replyText = document.querySelector('textarea#replyText').value;
        const writer = document.querySelector('input#writer').value;
        
        if (replyText === '') {
            alert('댓글 내용을 입력하세요.')
            return; // 내용이 없으면 더 이상 진행하면 안됨 return을 통해 메서드 종료
        }

        // Dto 클래스와 이름을 동일하게 맞춤
        // 2015년 이후 사용할 수 있는 문법 변수이름과 값의 이름을 동일하게하면 변수에 값이 자동으로 들어간다.
        const data = { postId, replyText, writer };

        // axios 라이브러리를 사용해서 Ajax 요청을 보냄.
        // (아규먼트) => {} 콜백함수 사용방법
        axios.post('/spring2/api/reply', data) // POST 방식의 Ajax 요청을 보냄
        
            // 성공 응답이 왔을 때 실행할 콜백 함수 등록
            .then((response) => {
                alert(`댓글 등록 성공(${response.data})`); // ReplyConstroller에서 리턴 한 값이 response.data에 들어가 있다.
                // 문자열 안에 값을 넣고 싶을 때는 ``을 쓰고 안에 넣을 값은 ${} 안에 넣자 
                
                // 댓글 입력 창의 내용을 지움
                document.querySelector('textarea#replyText').value = ''; // input과 textarea는 innerHTML이 아닌 value속성을 써야한다.
                
                // 댓글 목록 갱신
                
            })
            // 에러 응답이 왔을 때 실행할 콜백 함수 등록
            .catch((error) => {
                console.log(error);
            });
    };
    btnAddReply.addEventListener('click', createReply);
});