<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<title>글 삭제</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/board/script.js"></script>

<style>
th {
	background-color: #EEE
}
</style>

</head>
<body>

	<form action="<%=request.getContextPath()%>/BoardDeleteAction.bdo" method="post">
		<input type="hidden" name="board_num" value="${param.board_num }">
		<input type="hidden" name="page" value="${param.page }">
		<table cellpadding="0" cellspacing="0" align=center border=1>
			<tr align="center" valign="middle">
				<th colspan="2">글 삭제</th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input name="board_pw" id="board_pw" type="password" maxlength="10" value="" />
				</td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="2">
					<input type=submit value=" 삭제 ">
					<input type=reset value=" 취소 ">
				</td>
			</tr>
		</table>
	</form>
<%@ include file="/share/footer.jsp" %>
</body>
</html>