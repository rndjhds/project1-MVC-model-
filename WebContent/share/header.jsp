<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/admin_view.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<c:if test="${sessionScope.id=='admin'}">	<!-- 관리자 아이디 : admin으로 로그인 할시 출력 -->
<div class="header">
      <h1 class="info">모삼?책삼!</h1>
      <ul id="Login-status">
       <li>${sessionScope.id}님 환영합니다. 마일리지 : ${admin_mile}</li>
        <li><a href="<%=request.getContextPath()%>/admin/adminLogout.jsp">로그아웃</a></li>
        
    </div>

<div class="navbar">
	<a href="<%=request.getContextPath() %>/BookAdd.pdo"><strong>도서등록</strong></a>
	<a href="<%=request.getContextPath() %>/BookListAction.pdo">도서목록</a>
	<a href="<%=request.getContextPath() %>/OrderListAction.odo">주문확인</a>
	<a href="<%=request.getContextPath() %>/BoardListAction.bdo">답변하기</a>
	<a href="<%=request.getContextPath() %>/ManageAction.managedo">회원관리</a>	
</div>
</c:if>

<c:if test="${sessionScope.id == null}">	
<div class="header">
      <h1 class="info">모삼?책삼!</h1>
      <ul id="Login-status">
        <li><a href="<%=request.getContextPath() %>/LoginForm.mdo">회원 로그인</a></li>
        <li><a href="<%=request.getContextPath() %>/share/login_admin.jsp">관리자 로그인</a></li>
        <li><a href="<%=request.getContextPath() %>/MemberForm.mdo">회원가입</a></li>
    </div>

<div class="navbar">
	<a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=국내">국내도서</a>
	<a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=해외">해외도서</a>
	<a href="<%=request.getContextPath() %>/BookMain.pdo">최신도서</a>
	<a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의 게시판</a>
</div>
</c:if>

<c:if test="${sessionScope.id != 'admin' && sessionScope.id != null}"> <!--회원 로그인시 메뉴 -->
<div class="header">
      <div>
      	<h1 class="info">모삼?책삼!</h1>
      	<div>
      		<table id="Login-status" width=400 border=0>
	      		<tr>
	      			<td colspan=2>${member_name}님 환영합니다.</td>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/CartListAction.cdo">장바구니(${sessionScope.cartcount})</a></td>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/Logout.mdo">로그아웃</a></td>
	      		</tr>
	      		<tr>
	      			<td>회원등급 :</td>
	      			<td>${member_grade}</td>
	      			<td>마일리지 :</td>
	      			<td>${member_mile}</td>
	      		</tr>
	      		<tr>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의하기</a></td>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/UpdateMember.mdo">정보 수정</a></td>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/MileAdd.mdo">충전하기</a></td>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/DeleteMember.mdo">회원 탈퇴</a></td>
	      		</tr>
      		</table>
		</div>
     </div>
</div>

<div class="navbar">
   <a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=국내">국내도서</a>
   <a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=해외">해외도서</a>
   <a href="<%=request.getContextPath() %>/BookMain.pdo">최신도서</a>
   <a href="<%=request.getContextPath() %>/OrderConfirm.odo">주문확인</a>
   <a href="<%=request.getContextPath() %>/BookListAction.pdo">도서목록</a>
</div>      
</c:if>

</body>
</html>