<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/share/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모삼?책삼!</title>
<link href="<%=request.getContextPath()%>/css/admin_view.css"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<table align="center" class="tb">
	<caption><h3>도서 관리</h3></caption>
	<tr>
		<th>번호</th>
		<th>카테고리</th>
		<c:if test="${sessionScope.id=='admin'}">
			<th>도서코드</th>
		</c:if>
		<th>도서명</th>
		<th>저자</th>
		<th>출판사</th>
		<th>가격</th>
		<c:if test="${sessionScope.id=='admin'}">
			<th>재고</th>
			<th>판매</th>
		</c:if>
		<th>등록일</th>
		<c:if test="${sessionScope.id=='admin'}">
		<th></th>
		</c:if>
		<c:if test="${sessionScope.id != 'admin' && sessionScope.id != null}">
		<th></th></c:if>
	</tr>
	 <c:set var="num" value="${bookcount - (page-1) * 10 }" />
     <c:forEach var="b" items="${booklist}">
         <!--request객체로 공유해야 items에 공유 값을 입력하여 사용 할 수 있다.  -->
          <tr>
            <td class="tb1">${num}
               <c:set var="num" value="${num-1}" />
            </td>
            <td class="tb1">${b.book_category}</td>
            <c:if test="${sessionScope.id == 'admin'}">
            <td class="tb1"><a href="<%=request.getContextPath() %>/BookModify.pdo?book_num=${b.book_num}&page=${page}">${b.book_num}</a></td>
            </c:if>
            <td class="tb1">${b.book_name}</td>
            <td class="tb1">${b.book_author}</td>
            <td class="tb1">${b.book_pb}</td>
            <td class="tb1">${b.book_price}</td>            
            <c:if test="${sessionScope.id=='admin'}">
            <td class="tb1">${b.book_stock}</td> 
            <td class="tb1">${b.book_count}</td> 
            </c:if>
            <td class="tb1"><fmt:formatDate value="${b.book_reg}"
                  pattern="yyyy-MM-dd" /></td>
            <c:if test="${sessionScope.id=='admin'}">
            <td class="tb1"><input type="button" value="삭제" class="submit-btn" 
            	onClick="location.href='<%=request.getContextPath()%>/BookDelete.pdo?book_num=${b.book_num}&page=${page}'">
            </td></c:if>
            <c:if test="${sessionScope.id != 'admin' && sessionScope.id != null}">
            <td class="tb1">
            	<input type=button value="담기" class="submit-btn" 
            	onclick="location.href='./CartAdd.cdo?book_name=${b.book_name}&book_num=${b.book_num}&book_price=${b.book_price}'">
            </td></c:if>
         </tr>
         
     </c:forEach>
	
</table>

<!-- 페이지 처리 -->
<center>
<c:if test="${bookcount > 0}">

<!-- 1페이지로 이동 -->
<a href="./BookListAction.pdo?page=1" style="text-decoration: none"> << </a>

<!-- 이전 블록으로 이동 -->
<c:if test="${startPage > 10}">
<a href="./BookListAction.pdo?page=${startPage-10}" style="text-decoration: none"> [이전] </a>
</c:if>

<!-- 각 블럭에 10개의 페이지 출력 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i == page}">	<!-- 현재 페이지 -->
		[${i}]
	</c:if>
	<c:if test="${i != page}">	<!-- 현재 페이지가 아닌 경우 -->
		<a href="./BookListAction.pdo?page=${i}">[${i}]</a>
	</c:if>
</c:forEach>	
	
<!-- 다음 블럭으로 이동 -->
<c:if test="${endPage < pageCount }">
	<a href="./BookListAction.pdo?page=${startPage+10}" style="text-decoration: none">[다음]</a>
</c:if>
	
<!-- 마지막 페이지로 이동 -->
	<a href="./BookListAction.pdo?page=${pageCount}" style="text-decoration: none"> >> </a>

<c:if test="${sessionScope.id == 'admin' }">
<input type="button" value="등록하기" onClick="location.href='./BookAdd.pdo'">
</c:if>

</c:if>
</center>



<%@ include file="/share/footer.jsp" %>  
</body>
</html>