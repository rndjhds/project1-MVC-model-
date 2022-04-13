<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/admin_view.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="/share/header.jsp" %>
</head>
<body>

<table border=1 width=800 align=center>
		<caption>회원 관리</caption>
		<tr>
			<th>회원관리 번호</th>
			<th>회원아이디</th>
			<th>회원등급</th>
			<th>마일리지</th>			
			
		</tr>

		
		<c:set var="num" value="${listcount - (page-1) * 10 }" />
		<c:forEach var="b" items="${managelist}">
			<!--request객체로 공유해야 items에 공유 값을 입력하여 사용 할 수 있다.  -->
			<tr>
				<%-- <th>${num}
					<c:set var="num" value="${num-1}" />
				</th> --%>
				<th>${b.manage_num}</th>
				<th>${b.member_id}</th>
				<th>${b.member_grade}</th>
				<th>${b.member_mile}</th> 				
			</tr>
					
		</c:forEach>
		
		
	</table>
	<br><br><br>
	
	<input type="button" value="">
	<input type="button" value="취소">
<form method="post" action="<%=request.getContextPath() %>/"> 

</form>

</body>
</html>


<!-- 페이지 처리 -->
<center>
<c:if test="${listcount > 0}">

<!-- 1페이지로 이동 -->
<a href="./ManageAction.managedo?page=1" style="text-decoration:none"> << </a>

<!-- 이전 블럭으로 이동 -->
<c:if test="${startPage > 10}">
	<a href="./ManageAction.managedo.sdo?page=${startPage-10}">[이전]</a>
</c:if>

<!-- 각 블럭에 10개의 페이지를 출력 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i == page}">	<!-- 현재 페이지 -->
		[${i}]
	</c:if>
	<c:if test="${i != page}">	<!-- 현재 페이지가 아닌 경우 -->
		<a href="./ManageAction.managedo?page=${i}">[${i}]</a>
	</c:if>
</c:forEach>

<!-- 다음 블럭으로 이동 -->
<c:if test="${endPage < pageCount}">
	<a href="./ManageAction.managedo?page=${startPage+10}">[다음]</a>
</c:if>

<!-- 마지막 페이지로 이동 -->
<a href="./ManageAction.managedo?page=${pageCount}" 
	style="text-decoration:none"> >> </a>	

</c:if>
</center>


<br><br><br><br>

<%@ include file="/share/footer.jsp" %>



