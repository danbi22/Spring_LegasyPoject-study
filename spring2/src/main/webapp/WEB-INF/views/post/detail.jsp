<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	       <h1>상세 페이지</h1>
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
            </ul>
        </nav>        
        
        <main class="my-2">
            <section class="card">
                <form class="card-body" method="post">
                    <div class="my-3">
                        <label class="form-lable" for="id">번호</label>
                        <input class="form-control" id="id" value="${ post.id }" readonly />
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="title">제목</label>
                        <input class="form-control" id="title" value="${ post.title }" readonly />
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="content">내용</label>
                        <textarea class="form-control" id="content" readonly>${ post.content }</textarea>
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="author">작성자 아이디</label>
                        <input class="form-control" id="author" value="${ post.author }" readonly />
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="createdTime">작성 시간</label>
                        <fmt:formatDate var="createdTime" value="${ post.createdTime }" pattern="yyyy.MM.dd HH:mm"/>
                        <input class="form-control" id="createdTime" value="${ createdTime }" readonly>
                    </div>
                    <div class="my-3">
                        <label class="form-lable" for="modifiedTime">수정 시간</label>
                        <fmt:formatDate var="modifiedTime" value="${ post.modifiedTime }" pattern="yyyy.MM.dd HH:mm"/>
                        <input class="form-control" id="modifiedTime" value="${ modifiedTime }" readonly>
                    </div>
                </form>
                <div class="card-footer ">
                    <c:url var="postModifyPage" value="/post/modify">
                        <c:param name="id" value="${ post.id }"></c:param>
                    </c:url>        
                    <a class="form-control btn btn-outline-primary my-3"   
                    href="${ postModifyPage }">수정하기</a>
                </div>
            </section> <!-- 포스트 상세보기 카드 -->
            
            <section class="my-2 card">
                <div class="card-header text-bold">
                    <span>댓글</span>
                    <span id="replyCount">${ post.replyCount }</span> <!-- TODO: 실제 댓글 개수 -->
                    <button class="btn" id="btnToggleReply" data-toggle="toggle-off">ON</button>
                </div>
                <div class="card-body collapse" id="replyToggleDiv">
                    <!-- 나의 댓글 등록 -->
                    <div class="my-2 row">
                        <label class="form-lable" for="replyText">나의 댓글</label>
                        <div class="col-10">
                            <textarea class="form-control" id="replyText"></textarea>
                            <input class="d-none" id="writer" value="admin" /> <!-- TODO: 로그인 사용자 아이디 -->
                        </div>
                        <div class="col-2">
                            <button class="form-control btn btn-outline-success" id="btnAddReply">댓글 등록</button>
                        </div>
                    </div>
                    
                    <!-- 댓글 목록 보여줄 영역 -->
                    <div class="my-2 row" id="replies">
                    댓글 목록
                    </div>
                </div>
            </section> <!-- 댓글 등록, 댓글 리스트 카드 -->
            
        </main>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" 
                crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        <script src="../static/js/reply.js"></script>
    </div>    
	</body>
</html>