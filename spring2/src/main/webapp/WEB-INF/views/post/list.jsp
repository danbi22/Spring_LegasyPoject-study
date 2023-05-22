<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<body class="container-fluid"> 
    
		<header class="my-2 p-4 text-center text-bg-secondary">
            <h1 >포스트 목록 페이지</h1>  
        </header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <ul class="navbar-nav bg-light">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"/>
                    <a class="nav-link active" aria-current="page" href="${ mainPage }">메인 페이지</a>                
                </li>
                <li>
                    <c:url var="postCreatePage" value="/post/create"/>
                    <a class="nav-link" href="${ postCreatePage }">새글 작성하기</a>
                </li>
            </ul>
        </nav>
        <main>
            <div>
                <table class="table">
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">작성시간</th>
                    </tr>
                    
                    <c:forEach items="${ posts }" var="post">
                    <tr>
                        <td>${ post.id }</td>
                        <td>
                            <c:url var="PostDetailPage" value="/post/detail">
                                <c:param name="id" value="${ post.id }"></c:param>
                            </c:url>
                            <a href="${ PostDetailPage }">${ post.title }</a>
                            <span class="text-danger">[${ post.rcnt }]</span>
                        </td>
                        <td>${ post.author }</td>
                        <td>
                            <fmt:formatDate value="${ post.created_Time }" pattern="yyyy-MM-dd HH:mm" />
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" 
                crossorigin="anonymous">
        </script>    
	</body>
</html>