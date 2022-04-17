<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../share/header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<form action="./OrderAction.odo" method="post">
<input type="hidden" name="book_num" value="${book.book_num}">
<input type="hidden" name="member_id" value="${member_id}">

<h3 class="tb1">도서 상세정보</h3>
<div class="tb1"><img src="<%=request.getContextPath()%>/bookupload/${book.book_img}" width=50%></div>
<table align="center" class="tb">
		<th>도서 제목</th>
		<td colspan=2>${book.book_name}</td>
	</tr>
	</tr>
	<tr>
		<th>도서 저자</th>
		<td colspan=2>${book.book_author}</td>
	</tr>
	<tr>
		<th>도서 가격</th>
		<td colspan=2>${book.book_price}</td>
	</tr>
	<tr>
		<th>도서 출판사</th>
		<td colspan=2>${book.book_pb}</td>
	</tr>
	<tr>
		<th>도서 내용</th>
		<td colspan=2 class="con">${book.book_content}</td>
	</tr>
	<tr>
		<td colspan=3 align="center">
		
		<c:if test="${sessionScope.id == null}">
		     <input type=button value="구매하기" onclick="location.href='./LoginForm.mdo'" class="submit-btn">
			 <input type=button value="담기" onclick="location.href='./LoginForm.mdo'" class="submit-btn">
			 <input type=button value="뒤로가기" onClick="location.href='./BookMain.pdo?page=${page}'" class="submit-btn"></c:if>
		<c:if test="${sessionScope.id != null}">
			 <input type=submit value="구매하기" class="submit-btn">
			 <input type=button value="담기" onclick="location.href='./CartAdd.cdo?book_name=${book.book_name}&book_num=${book.book_num}&book_price=${book.book_price}'" class="submit-btn">
			 <input type=button value="뒤로가기" onClick="location.href='./BookMain.pdo?page=${page}'" class="submit-btn"></c:if>
		</td>
	</tr>
</table>

</form>


 <div class="footer">
      <img src="book_img/facebook.png" height="20px"></a>
      <img src="book_img/instagram.png" height="20px"></a>
      <img src="book_img/twitter.png" height="20px"></a>
 </div>
</body>
</html>