<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/admin_view.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/book/book.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>  
</head>
<body>


<form method="post" action="<%=request.getContextPath() %>/BookInsert.pdo" enctype="multipart/form-data">
	<table align="center" class="tb">
		<caption>상품등록</caption>
		<tr>
			<th>도서제목</th>
			<td><input type="text" name="book_name" id="book_name" size=40></td>
		</tr>
		<tr>
			<th>도서저자</th>
			<td><input type="text" name="book_author" id="book_author" size=40></td>
		</tr>
		<tr>
			<th>도서가격</th>
			<td><input type="text" name="book_price" id="book_price" size=40></td>
		</tr>
		<tr>
			<th>도서재고량</th>
			<td><input type="text" name="book_stock" id="book_stock" size=40></td>
		</tr>
		<tr>
			<th>도서출판사</th>
			<td><input type="text" name="book_pb" id="book_pb" size=40></td>
		</tr>
		<tr>
			<th>도서카테고리</th>
			<td><input type="text" name="book_category" id="book_category" size=40></td>
		</tr>
		<tr>
			<th>도서파일</th>
			<td><input type="file" name="book_img" id="book_img" size=40></td>
		</tr>
		<tr>
			<th>도서내용</th>
			<td>
				<textarea id="book_content" name="book_content" rows="6" cols="50" placeholder="책내용을 200자 이내로 입력하세요"></textarea>
			</td>
		</tr>
		<tr align="center">
			<td colspan=2>
				<input type="submit" value="상품등록" class="submit-btn">
				<input type="reset" value="취소" class="submit-btn">		
			</td>
		</tr>
	</table>
</form>
<%@ include file="/share/footer.jsp" %>  
</body>
</html>