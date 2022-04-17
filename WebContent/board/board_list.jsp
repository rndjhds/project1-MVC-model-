<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<caption><h3>문의 게시판</h3></caption>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
		<th>조회수</th>
		<th>답변여부</th>
	</tr>
	<c:set var="num" value="${listcount - (page - 1) * 10}" />
	<c:forEach var="b" items="${boardlist}">
	<tr align=center>
		<td>
			${num}
			<c:set var="num" value="${num - 1}" />
		</td>
		<td  class="tb1"><!-- 댓글 여백 처리 -->
			<c:if test="${b.board_lev > 0}">
				<c:forEach var="i" begin="0" end="${b.board_lev }">
				&nbsp;&nbsp;
				</c:forEach>
			</c:if>
			<c:if test="${sessionScope.id != null}">
			<a href="./BoardDetailAction.bdo?board_num=${b.board_num}&page=${page}">${b.board_subject}</a>
			</c:if>
			<c:if test="${sessionScope.id == null}">
			<a href="./BoardAlert.bdo">${b.board_subject}</a>
			</c:if>
		</td>
		<td>
			${b.board_writer}
		</td>
		<td>
			<fmt:formatDate value="${b.board_date}" pattern="yyyy-MM-dd" /></td>
		<td>
			${b.board_rc}
		</td>
		<td>
			<c:if test="${b.board_check==0 && b.board_lev==0}">답변대기</c:if>
			<c:if test="${b.board_check==1 && b.board_lev==0}">답변완료</c:if>
		</td>
	</tr>
	</c:forEach>
</table>
<br><br>

<!-- 페이지 처리 -->
<center>
	<c:if test="${listcount > 0}">

		<a href="./BoardListAction.bdo?page=1" style="text-decoration: none"> << </a>

		<c:if test="${startPage > 5}">
			<a href="./BoardListAction.bdo?page=${startPage - 5}" style="text-decoration: none"> [이전] </a>
		</c:if>

		<!-- 5개 페이지 출력 -->
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == page}">
				[${i}]
			</c:if>
			<c:if test="${i != page}">
				<a href="./BoardListAction.bdo?page=${i}"> [${i}] </a>
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < pageCount }">
			<a href="./BoardListAction.bdo?page=${startPage + 5}" style="text-decoration: none"> [다음] </a>
		</c:if>
		
		<a href="./BoardListAction.bdo?page=${pageCount}" style="text-decoration: none"> >> </a>
		
	</c:if>
	<c:if test="${sessionScope.id != null}">
	<a href="./BoardInsertForm.bdo"><input type="button" value="문의하기"></a>
	</c:if>
	<c:if test="${sessionScope.id == null}">
	<input type="button" value="문의하기" onClick="location.href='./BoardAlert.bdo'">
	</c:if>
	
<form method=post action="./BoardListAction.bdo" class="mar">
	<div class="mar">
	<select name="sel">
		<option value="">검색</option>
		<option value="board_writer">작성자</option>
		<option value="board_subject">제목</option>
		<option value="board_content">내용</option>
	</select>
	<input type=text name="find" id="find">
	<input type=submit value="검색">
	</div>
</form>
</center>
<%@ include file="/share/footer.jsp" %>
</body>
</html>
