<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모삼?책삼!</title>
<link href="<%=request.getContextPath() %>/css/admin_view.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<c:if test="${sessionScope.id=='admin'}">	<!-- 관리자 아이디 : admin으로 로그인 할시 출력 -->
<div class="header">
      <h1 class="info"><a href="<%=request.getContextPath() %>/BookMain.pdo" style="text-decoration: none">모삼?책삼!</a></h1>
      <ul id="Login-status">
       <li>${sessionScope.id}님 환영합니다.</li></ul>
       <div class="clearfix"></div>
       <ul id="Login-status">
        <li><a href="<%=request.getContextPath()%>/admin/adminLogout.jsp">로그아웃</a></li>
       <li>마일리지 : ${admin_mile}</li></ul>
        
    </div>

<div class="navbar">
	<a href="<%=request.getContextPath() %>/BookListAction.pdo">도서관리</a>
	<a href="<%=request.getContextPath() %>/ManageAction.managedo">회원관리</a>	
	<a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의관리</a>
	<a href="<%=request.getContextPath() %>/OrderListAction.odo">주문관리</a>
</div>
</c:if>

<c:if test="${sessionScope.id == null}">	
<div class="header">
      <h1 class="info"><a href="<%=request.getContextPath() %>/BookMain.pdo" style="text-decoration: none">모삼?책삼!</a></h1>
      <ul id="Login-status">
        <li><a href="<%=request.getContextPath() %>/share/login_admin.jsp">관리자 로그인</a></li>
        <li><a href="<%=request.getContextPath() %>/MemberForm.mdo">회원가입</a></li>
    	<li><a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의하기</a></li>  
        <li><a href="<%=request.getContextPath() %>/LoginForm.mdo">회원 로그인</a></li>
    </div>

<div class="navbar">
	<a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=국내">국내도서</a>
	<a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=해외">해외도서</a>
	<a href="<%=request.getContextPath() %>/BookMain.pdo">최신도서</a>
	<a href="<%=request.getContextPath() %>/BookListAction.pdo">도서전체</a>
</div>
</c:if>

<c:if test="${sessionScope.id != 'admin' && sessionScope.id != null}"> <!--회원 로그인시 메뉴 -->
<div class="header">
      	<h1 class="info"><a href="<%=request.getContextPath() %>/BookMain.pdo" style="text-decoration: none">모삼?책삼!</a></h1>
      	<ul id="Login-status1">${member_name}님 환영합니다.</ul>
      	<div class="clearfix"></div>
      	<ul id="Login-status">
        <li><a href="<%=request.getContextPath() %>/Logout.mdo">로그아웃</a></li>
       <li>마일리지 : ${member_mile}</li></ul>
		<div class="clearfix"></div>       
       	<ul id="Login-status" class="mar0">
        <li><a href="<%=request.getContextPath() %>/CartListAction.cdo">장바구니(${sessionScope.cartcount})</a></li>
       <li>회원등급 :${member_grade}</li></ul>
       <div class="clearfix"></div>
       	<ul id="Login-status" class="mar0">
        <li><a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의하기</a></li>
       <li><a href="<%=request.getContextPath() %>/UpdateMember.mdo">정보 수정</a></li>
        <li><a href="<%=request.getContextPath() %>/MileAdd.mdo">충전하기</a></li></ul>
       
      		<%-- <table id="Login-status" width=600>
	      		<tr>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의하기</a></td>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/UpdateMember.mdo">정보 수정</a></td>
	      			<td class="tb2"><a href="<%=request.getContextPath() %>/MileAdd.mdo">충전하기</a></td>
	      		</tr>
      		</table> --%>
</div>

<div class="navbar">
   <a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=국내">국내도서</a>
   <a href="<%=request.getContextPath() %>/BookDomestic.pdo?book_category=해외">해외도서</a>
   <a href="<%=request.getContextPath() %>/BookMain.pdo">최신도서</a>
   <a href="<%=request.getContextPath() %>/BookListAction.pdo">도서전체</a>
   <a href="<%=request.getContextPath() %>/OrderConfirm.odo">주문확인</a>
</div>      
</c:if>

</body>
</html>