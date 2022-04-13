<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<title>글 수정</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/board/script.js"></script>

<style>
th {
	background-color: #EEE
}
</style>

</head>
<body>

	<form action="<%=request.getContextPath()%>/BoardUpdateAction.bdo"
		method="post">
		<input type="hidden" name="board_num" value="${board.board_num }">
		<input type="hidden" name="page" value="${page }">
		<table cellpadding="0" cellspacing="0" align=center border=1>
			<tr align="center" valign="middle">
				<th colspan="2">글 수정</th>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>
					<input name="board_writer" id="board_writer" type="text" maxlength="10" value="" />
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input name="board_pw" id="board_pw" type="password" maxlength="10" value="" />
				</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>
					<input name="board_subject" id="board_subject" type="text" size="50" maxlength="100" value="" />
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td>
					<textarea name="board_content" id="board_content" cols="80" rows="15"></textarea>
				</td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="2">
					<input type=submit value=" 수정 ">
					<input type=reset value=" 취소 ">
				</td>
			</tr>
		</table>
	</form>
<%@ include file="/share/footer.jsp" %>
</body>
</html>