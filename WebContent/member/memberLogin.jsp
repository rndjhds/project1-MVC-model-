<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
<link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 외부 자바스크립트 파일 -->
<script src="<%=request.getContextPath()%>/member/login.js"></script>

</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/Login.mdo">
<table border=1 width=400 align=center>
	<tr>
		<th colspan=2>회원 로그인</th>
	</tr>
	<tr>
		<td>회원 아이디</td>
		<td><input type=text name="member_id" id="member_id" width=100% autofocus="autofocus">
		<div id="idCheck"></div>
		</td>
		
	</tr>
	<tr>
		<td>회원 비밀번호</td>
		<td><input type=password name="member_pw" id="member_pw">
		<div id="pwCheck"></div>
		</td>
		
	</tr>
	<tr align="center">
		<td colspan=2>
		<input type="submit" value="로그인">
		<input type="reset" value="취소"></td>
	</tr>
</table>
</form>

<%-- 	<form method="post" action="<%=request.getContextPath()%>/Login.do">
		<table border=1 width=350 align=center>
			<caption>로그인</caption>
			<tr>
				<td>아이디</td>
				<td><input type=text size=30 id="member_id" name="member_id"
					autofocus="autofocus"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" size=30 id="member_pw" name="member_pw"></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
				<input type="button" value="회원 가입"
					onClick="location.href='<%=request.getContextPath()%>/MemberForm.mdo' ">
				<input type="submit" value="로그인">
				<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form> --%>

<%@ include file="/share/footer.jsp" %>

</body>
</html>