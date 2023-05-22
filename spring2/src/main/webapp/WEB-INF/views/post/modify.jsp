<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Spring 2</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" 
              crossorigin="anonymous">
	</head>
	<body>
	<div class="container-fluid">
        <header class="my-2 p-4 text-center text-bg-secondary">
	       <h1>포스트 수정하기</h1>
        </header>
        
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <ul class="navbar-nav bg-light">
                <li>
                    <c:url var="mainPage" value="/"/>
                    <a class="nav-link active" aria-current="page" href="${ mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="postListPage" value="/post/list"/>
                    <a class="nav-link active" aria-current="page" href="${ postListPage }">포스트 목록</a>
                </li>
                <li>
                    <c:url var="postDetailPage" value="/post/detail">
                        <c:param name="id" value="${ post.id }"></c:param>
                    </c:url>
                    <a class="nav-link active" aria-current="page" href="${ postDetailPage }">상세보기</a>
                </li>
            </ul>
        </nav>        
        
        <main class="my-2">
            <div class="card">
                <form class="card-body" method="post" id="modify-form">
                    <div class="my-3">
                        <label class="form-lable" for="id">번호</label>
                        <input name="id" class="form-control" id="id" value="${ post.id }" readonly />
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="title">제목</label>
                        <input name="title" class="form-control" id="title" value="${ post.title }" />
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="content">내용</label>
                        <textarea name="content" class="form-control" id="content">${ post.content }</textarea>
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="author">작성자 아이디</label>
                        <input class="form-control" id="author" value="${ post.author }" readonly />
                    </div>
                </form>
            <div class="card-footer">
                <div class="d-flex">
                    <c:url var="postDelete" value="/post/delete">
                        <c:param name="id" value="${ post.id }"></c:param>
                    </c:url>
                    <a href="${ postDelete }">
                        <button class="mx-1 btn btn-outline-danger" id="btnDelete">삭제</button>
                    </a>
                    
                    <button class="mx-1 btn btn-outline-success" id="btnUpdate">업데이트</button>
                    
                </div>
            </div>
            </div>
        </main>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" 
                crossorigin="anonymous">
        </script>
        <script src="../static/js/post-update.js"></script>
    </div>    
	</body>
</html>