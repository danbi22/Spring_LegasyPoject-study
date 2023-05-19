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
            <h1>포스트 작성</h1>
        </header>		
        
        
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <ul class="navbar-nav bg-light">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"/>
                    <a class="nav-link active" aria-current="page" href="${ mainPage }">메인 페이지</a>
                </li>
                <li class="nav-item">
                    <c:url var="postListPage" value="/post/list"/>
                    <a class="nav-link active" aria-current="page" href="${ postListPage }">포스트 목록</a>
                </li>
            </ul>        
        </nav>
        
        <main class="my-2">
            <div class="card">
                <form method="post">
                    <div class="card-body">
                        <div class="my-3">
                            <label class="form-lable" for="title">제목</label>
                            <input class="form-control" type="text" id="title" name="title" required autofocus/>
                        </div>
                        <div class="my-3">
                            <label class="form-lable" for="content">내용</label>
                            <textarea class="form-control" id="content" name="content" required></textarea>
                        </div>
                        <div class="my-3">
                            <label class="form-lable" for="author">작성자 아이디</label>
                            <input class="form-control" type="text" id="author" name="author" required>
                        </div>
                    </div>
                    <div class="card-footer">
                        <input class="form-control btn btn-outline-primary my-3" type="submit" value="작성완료" />
                    </div>
                </form>
            </div>
        </main>
        
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" 
                crossorigin="anonymous">
        </script>
    </div>
	</body>
</html>