<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/admin_view.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>


<form method="post" action="">
	<table border=1 align="center">
		<tr>
			<th>회원아이디</th>
			<td><input type="text" name="#" id="#"> 
				<div id="client_idcheck"></div>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text"></td>
		</tr>
		<tr align="center">
			<td colspan=2>
				<input type="submit" value="로그인">
				<input type="reset" value="취소"> 
			</td>
		</tr>
	</table>
</form>
<%@ include file="footer.jsp" %>

</body>
</html>