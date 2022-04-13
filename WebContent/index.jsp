<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>


 <div class="products">
 	<div class="product1">
      <a href="#"><img src="book_img/국내도서1.jpg"><span>국내도서1</span>49,000</a>
      <a href="#"><img src="book_img/국내도서2.jpg"><span>국내도서2</span>89,000</a>
      <a href="#"><img src="book_img/국내도서3.jpg"><span>국내도서3</span>69,000</a>
      <a href="#"><img src="book_img/국내도서4.jpg"><span>국내도서4</span>79,000</a>
    </div>
    <div class="product2">
      <a href="#"><img src="book_img/국내도서5.jpg"><span>국내도서5</span>29,000</a>
      <a href="#"><img src="book_img/국내도서6.jpg"><span>국내도서6</span>99,000</a>
      <a href="#"><img src="book_img/국내도서7.jpg"><span>국내도서7</span>39,000</a>
      <a href="#"><img src="book_img/국내도사8.jpg"><span>국내도서8</span>99,000</a>
    </div>  
      <div class="clearfix"></div>
 </div>
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