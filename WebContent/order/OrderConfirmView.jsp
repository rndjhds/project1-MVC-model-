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

<table width=1000 align=center class="tb">
		<caption>주문확인<br><br></caption>
		<tr>
			<th>주문번호</th>
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
		<%-- <c:if test="${b.order_status=='배송대기'}"> --%>
			<!--request객체로 공유해야 items에 공유 값을 입력하여 사용 할 수 있다.  -->
			<tr>
				<%-- <th>${num}
					<c:set var="num" value="${num-1}" />
				</th> --%>
				<td class="tb1">${b.order_num}</td>				
				<td class="tb1">${b.book_num}</td> 
				<td class="tb1">${b.book_name}</td>				
				<td class="tb1">${b.order_qty}</td>
				<td class="tb1">${b.book_price}</td>
				<td class="tb1">${b.order_status}</td>
				<td class="tb1"><fmt:formatDate value="${b.order_date}"
						pattern="yyyy-MM-dd HH:mm:ss EEE요일" /></td>
				<td class="tb1">
			
			 	<c:if test="${b.order_status=='배송대기'}"><input type=button value="주문취소"
			 onclick="location.href='./OrderCancel.odo?member_id=${b.member_id}&order_num=${b.order_num}&book_price=${b.book_price}'"></c:if>
			 <c:if test="${b.order_status=='배송완료'}"><input type=button value="구매확정"
			 onclick="location.href='./BuyEnd.odo?order_num=${b.order_num}&book_price=${b.book_price}'"></c:if>
			 </td>		
				
			</tr>
			<c:set var="t" value="${b.order_qty * b.book_price}"/>
			<c:set var="total" value="${total + t}"/>
			
		</c:forEach>

	</table>
	<br><br><br>
	
</body>
</html>

<br><br><br><br>

<%@ include file="/share/footer.jsp" %>



