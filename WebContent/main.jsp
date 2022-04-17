<%@page import="java.util.List"%>
<%@page import="model.BookDTO"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="share/header.jsp" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	
	<div class=products>
 	<c:forEach var="book" items="${booklist}">
      <a href="./BookDetail.pdo?book_num=${book.book_num}&page=${page}"><img src="<%=request.getContextPath()%>/bookupload/${book.book_img}"><span>${book.book_name}</span>${book.book_price}</a> 
    </c:forEach>  
    </div>  
    
    <div class=clearfix></div>
    
    
    
<!-- 페이지 처리 -->
<center>
<c:if test="${bookcount > 0}">

<!-- 1페이지로 이동 -->
<a href="./BookMain.pdo?page=1" style="text-decoration: none"> << </a>

<!-- 이전 블록으로 이동 -->
<c:if test="${startPage > 5}">
<a href="./BookMain.pdo?page=${startPage-5}" style="text-decoration: none"> [이전] </a>
</c:if>

<!-- 각 블럭에 5개의 페이지 출력 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i == page}">	<!-- 현재 페이지 -->
		[${i}]
	</c:if>
	<c:if test="${i != page}">	<!-- 현재 페이지가 아닌 경우 -->
		<a href="./BookMain.pdo?page=${i}">[${i}]</a>
	</c:if>
</c:forEach>	
	
<!-- 다음 블럭으로 이동 -->
<c:if test="${endPage < pageCount }">
	<a href="./BookMain.pdo?page=${startPage+5}" style="text-decoration: none">[다음]</a>
</c:if>
	
<!-- 마지막 페이지로 이동 -->
	<a href="./BookMain.pdo?page=${pageCount}" style="text-decoration: none"> >> </a>


</c:if>
</center>

 `
    
    <div class="footer">
      <img src="book_img/facebook.png" height="20px"></a>
      <img src="book_img/instagram.png" height="20px"></a>
      <img src="book_img/twitter.png" height="20px"></a>
    </div>

<!-- <div class="navbar">
	
	<ul>
		<li><a href="#">국내도서</a></li>
		<li><a href="#">해외도서</a></li>
		<li><a href="#">문의게시판</a></li>
		<li><a href="#">최신도서</a></li>
	</ul>

</div>

<table align="center">
	<caption>메인 페이지</caption>
	<tr>
		<td><input type="text" name="member_id" id="member_pw" placeholder="아이디"></td>
		<td><input type="button" name="client" id="client" value="클라 로그인"
			onClick="location.href='MemberView.jsp'">
	</tr>
	<tr>
		<td><input type="text" name="member_pw" id="member_pw" placeholder="비밀번호"></td>
		<td><input type="button" name="admin" id="admin" value="관리자 로그인"
			onClick="location.href='login_admin.jsp'">
	</tr>
</table> -->

</body>
</html>