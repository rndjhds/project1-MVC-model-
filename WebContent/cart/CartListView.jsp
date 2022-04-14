<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 리스트</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/cart/cart.js"></script>

</head>
<body>
<form method=post action="<%=request.getContextPath() %>/CartBuy.cdo">
	<table width=700 align="center" class="tb">
		<caption>장바구니 리스트<br><br></caption>
		<tr>
			<th>카트번호</th>
			<th>도서번호</th>
			<th>도서이름</th>
			<th>도서가격</th>
			<th>기타</th>
		</tr>
		<c:forEach var="c" items="${cartlist}">
		<tr align="center">
			<td><input type="checkbox" name="cartsel" 
			value="${c.cart_no}">${c.cart_no}</td>
			<td>${c.cbook_num}</td>
			<td>${c.cbook_name}</td>
			<td>${c.cbook_price}</td>
			<td><input type=button value="삭제"
			 onclick="location.href='./CartDel.cdo?cart_no=${c.cart_no}'"></td>
		</tr>
		</c:forEach>
		<tr align="center">
			<td colspan=5>
				<input type="submit" value="구매" class="submit-btn">
			</td>
		</tr>
	</table>
</form>
<%@ include file="/share/footer.jsp" %>
</body>
</html>