<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/admin_view.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>  
</head>
<body>

<form method="post" action="#">
	<table align="center" border=1>
		<caption>판매관리</caption>
		<tr>
			<th>판매번호</th>
			<th>회원아이디</th>
			<th>도서번호</th>
			<th>주문번호</th>
			<th>판매가격</th>
			<th>주문수</th>
			<th>판매날짜</th>
			<th>개인 총매출</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		
	</table>
</form>

<%@ include file="/share/footer.jsp" %>  

</body>
</html>