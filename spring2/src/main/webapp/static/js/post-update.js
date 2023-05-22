/**
 * post-update.js
 * modify.jsp
 */
document.addEventListener("DOMContentLoaded", function(){
    const id = document.querySelector('#id');
    const title = document.querySelector('#title');
    const content = document.querySelector('#content');
    const form = document.querySelector('#modify-form');
    const btnUpdate = document.querySelector('#btnUpdate');
    
    
    btnUpdate.addEventListener('click', function(){
        const idValue = id.value;
        const titleValue = title.value;
        const contentValue = content.value;
        
        if (titleValue === '' || contentValue === '') {
            alert('제목과 내용은 반드시 입력해야 합니다.')
        }
        
        const result = confirm(`No.${idValue} 글을 정말 변경할까요?`);
        
        if(result){
            form.action = 'update';
            form.method = 'post';
            form.submit();
            alert('변경되었습니다.');
        }
    });
});