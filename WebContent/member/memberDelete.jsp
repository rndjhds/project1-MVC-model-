<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 외부 자바스크립트 파일 -->
<script src="member.js"></script>

</head>
<body>

	<form method="post" action="<%=request.getContextPath()%>/Delete.mdo"
	 onsubmit="return confirm('탈퇴하시겠습니까?')">
		<input type="hidden" name="member_id" value="${sessionScope.id}">
		<table width=300 align=center class="tb">
			<tr>
				<th colspan=2>회원 탈퇴</th>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type=password id="member_pw" name="member_pw"></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
				<input type=submit value="회원 탈퇴" class="submit-btn">
				<input type="button" value="취소" onClick="history.go(-1)" class="submit-btn"></td>
			</tr>
		</table>
	</form>
	
<%@ include file="/share/footer.jsp" %>

</body>
</html>