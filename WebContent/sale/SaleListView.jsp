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
		<caption>판매 내역</caption>
		<tr>
			<th>번호</th>
			<th>판매 번호</th>
			<th>회원아이디</th>
			<th>도서번호</th>
			<th>도서명</th>
			<th>판매가격</th>
			<th>주문수</th>
			<th>판매날짜</th>
			<th>판매금액</th>
			
		</tr>

		<c:set var="total" value="0"/>
		<c:set var="num" value="${listcount - (page-1) * 10 }" />
		<c:forEach var="b" items="${salelist}">
			<!--request객체로 공유해야 items에 공유 값을 입력하여 사용 할 수 있다.  -->
			<tr>
				<th>${num}
					<c:set var="num" value="${num-1}" />
				</th>
				<th>${b.sale_num}</th>
				<th>${b.member_id}</th>
				<th>${b.book_num}</th>
				<th>${b.book_name}</th> 
				<th>${b.book_price}</th>				
				<th>${b.sale_qty}</th>
				<th><fmt:formatDate value="${b.sale_date}"
						pattern="yyyy-MM-dd HH:mm:ss EEE요일" /></th>
				<th>${b.sale_qty * b.book_price}</th>
			</tr>
			<c:set var="t" value="${b.sale_qty * b.book_price}"/>
			<c:set var="total" value="${total + t}"/>
			
		</c:forEach>
		
		<tr>
			<th  colspan=8>총판매금액</th>
			<th>${total}</th>
		</tr>


	</table>
	<br><br><br>
	
	<input type="button" value="확인">
	<input type="button" value="취소">


</body>
</html>


<!-- 페이지 처리 -->
<center>
<c:if test="${listcount > 0}">

<!-- 1페이지로 이동 -->
<a href="./SaleListAction.sdo?page=1" style="text-decoration:none"> << </a>

<!-- 이전 블럭으로 이동 -->
<c:if test="${startPage > 10}">
	<a href="./SaleListAction.sdo?page=${startPage-10}">[이전]</a>
</c:if>

<!-- 각 블럭에 10개의 페이지를 출력 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i == page}">	<!-- 현재 페이지 -->
		[${i}]
	</c:if>
	<c:if test="${i != page}">	<!-- 현재 페이지가 아닌 경우 -->
		<a href="./SaleListAction.sdo?page=${i}">[${i}]</a>
	</c:if>
</c:forEach>

<!-- 다음 블럭으로 이동 -->
<c:if test="${endPage < pageCount}">
	<a href="./SaleListAction.sdo?page=${startPage+10}">[다음]</a>
</c:if>

<!-- 마지막 페이지로 이동 -->
<a href="./SaleListAction.sdo?page=${pageCount}" 
	style="text-decoration:none"> >> </a>	

</c:if>
</center>


<br><br><br><br>

<%@ include file="/share/footer.jsp" %>



