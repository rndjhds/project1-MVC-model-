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

<table width=1300 align=center class="tb">
		<caption>판매 내역</caption>
		<tr>
			<th>주문번호</th>
			<th>회원아이디</th>
			<th>회원이름</th>
			<th>도서번호</th>
			<th>도서명</th>
			<th>주문수량</th>
			<th>책가격</th>
			<th>주문상태</th>
			<th>날짜</th>
			<th>주문상태 변경</th>
			
		</tr>

		<c:set var="total" value="0"/>
		<c:set var="num" value="${listcount - (page-1) * 10 }" />
		<c:forEach var="b" items="${orderlist}">
			<!--request객체로 공유해야 items에 공유 값을 입력하여 사용 할 수 있다.  -->
			<tr>
				<%-- <th>${num}
					<c:set var="num" value="${num-1}" />
				</th> --%>
				<td class="tb1">${b.order_num}</td>
				<td class="tb1">${b.member_id}</td>
				<td class="tb1">${b.member_name}</td>
				<td class="tb1">${b.book_num}</td> 
				<td class="tb1">${b.book_name}</td>				
				<td class="tb1">${b.order_qty}</td>
				<td class="tb1">${b.book_price}</td>
				<td class="tb1">${b.order_status}</td>
				<td class="tb1"><fmt:formatDate value="${b.order_date}"
						pattern="yyyy-MM-dd HH:mm:ss EEE요일" /></td>
				<td class="tb1"><c:if test="${b.order_status=='배송대기'}"><input type=button value="배송시작"
			 onclick="location.href='./Delivery.odo?order_num=${b.order_num}'">
			 		<input type=button value="주문취소"
			 onclick="location.href='./OrderCancel.odo?member_id=${b.member_id}&order_num=${b.order_num}&book_price=${b.book_price}'">
			 </c:if></td>	
				
			</tr>
			<c:set var="t" value="${b.order_qty * b.book_price}"/>
			<c:set var="total" value="${total + t}"/>
			
		</c:forEach>
		
		<tr>
			<th  colspan=9>총판매금액</th>
			<th>${total}</th>
		</tr>


	</table>
	<br><br><br>
	
	<!-- <input type="button" value="확인">
	<input type="button" value="취소"> -->


</body>
</html>


<!-- 페이지 처리 -->
<center>
<c:if test="${listcount > 0}">

<!-- 1페이지로 이동 -->
<a href="./OrderListAction.odo?page=1" style="text-decoration:none"> << </a>

<!-- 이전 블럭으로 이동 -->
<c:if test="${startPage > 10}">
	<a href="./OrderListAction.odo?page=${startPage-10}">[이전]</a>
</c:if>

<!-- 각 블럭에 10개의 페이지를 출력 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i == page}">	<!-- 현재 페이지 -->
		[${i}]
	</c:if>
	<c:if test="${i != page}">	<!-- 현재 페이지가 아닌 경우 -->
		<a href="./OrderListAction.odo?page=${i}">[${i}]</a>
	</c:if>
</c:forEach>

<!-- 다음 블럭으로 이동 -->
<c:if test="${endPage < pageCount}">
	<a href="./OrderListAction.odo?page=${startPage+10}">[다음]</a>
</c:if>

<!-- 마지막 페이지로 이동 -->
<a href="./OrderListAction.odo?page=${pageCount}" 
	style="text-decoration:none"> >> </a>	

</c:if>
</center>


<br><br><br><br>

<%@ include file="/share/footer.jsp" %>



