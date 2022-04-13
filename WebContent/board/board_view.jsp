<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/admin_view.css"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

<style>
table {
	border-top: 1px solid;
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid;
	padding: 10px;
}

th {
	background-color: #EEE
}
</style>

<table width=900 align=center>
	<caption>상세 페이지</caption>
	<tr>
		<th>제목</th>
		<td>${board.board_subject}</td>
		<th>글쓴이</th>
		<td>${board.board_writer}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan=3>${content}</td>
	</tr>
	<tr>
		<td colspan=4 align=center>
			<input type="button" value=" 댓글 "
			onClick="location.href='./BoardReplyForm.bdo?board_num=${board.board_num}&page=${page}'">&nbsp;
			<input type="button" value=" 수정 "
			onClick="location.href='./BoardUpdateForm.bdo?board_num=${board.board_num}&page=${page}'">&nbsp;
			<input type="button" value=" 삭제 "
			onClick="location.href='./BoardDeleteForm.bdo?board_num=${board.board_num}&page=${page}'">&nbsp;
			<input type="button" value=" 목록 "
			onClick="location.href='./BoardListAction.bdo?page=${page}'">
		</td>
	</tr>
</table>
</body>
<%@ include file="/share/footer.jsp" %>
</html>
