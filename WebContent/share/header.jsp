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
        <li>관리자님 환영합니다.</li>
        <li>로그아웃</li>
        
    </div>

<div class="navbar">
	<a href="<%=request.getContextPath() %>/BookAdd.pdo"><strong>도서등록</strong></a>
	<a href="<%=request.getContextPath() %>/BookListAction.pdo">도서목록</a>
	<a href="<%=request.getContextPath() %>/SaleListAction.sdo">판매관리</a>
	<a href="<%=request.getContextPath() %>/board/boardlistview.jsp">답변하기</a>
	<a href="<%=request.getContextPath() %>/ManageAction.managedo">회원관리</a>	
</div>
</c:if>

<c:if test="${sessionScope.id !='admin' && sessionScope.id == null}">	
<div class="header">
      <h1 class="info">모삼?책삼!</h1>
      <ul id="Login-status">
        <li><a href="<%=request.getContextPath() %>/LoginForm.mdo">회원 로그인</a></li>
        <li><a href="<%=request.getContextPath() %>/share/login_admin.jsp">관리자 로그인</a></li>
        <li><a href="<%=request.getContextPath() %>/MemberForm.mdo">회원가입</a></li>
    </div>

<div class="navbar">
	<a href="<%=request.getContextPath() %>/book/bookdomestic.jsp">국내도서</a>
	<a href="<%=request.getContextPath() %>/book/bookforeign.jsp">해외도서</a>
	<a href="<%=request.getContextPath() %>/book/booklatest.jsp">최신도서</a>
	<a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의 게시판</a>
</div>
</c:if>

<c:if test="${sessionScope.id != 'admin' && sessionScope.id != null}"> <!-- 관리자 아이디 이외에 로그인 할시 출력(회원 로그인) -->
<div class="header">
      <h1 class="info">모삼?책삼!</h1>
      <ul id="Login-status">
      <li>${grade}등급</li>
      </ul>
      <ul id="Login-status">
        <li>${sessionScope.id}님 환영합니다.</a></li> <br>
        <li><a href="#">문의하기</a></li>
        <li><a href="#">충전하기</a></li>
        <li><a href="<%=request.getContextPath() %>/UpdateMember.mdo">정보 수정</a></li>
        <li><a href="<%=request.getContextPath() %>/DeleteMember.mdo">회원 탈퇴</a></li>
        <li><a href="<%=request.getContextPath() %>/Logout.mdo">로그아웃</a></li>
</div>

<div class="navbar">
   <a href="<%=request.getContextPath() %>/book/bookdomestic.jsp">국내도서</a>
   <a href="<%=request.getContextPath() %>/book/bookforeign.jsp">해외도서</a>
   <a href="<%=request.getContextPath() %>/book/booklatest.jsp">최신도서</a>
   <a href="<%=request.getContextPath() %>/BoardListAction.bdo">문의 게시판</a>
</div>      
</c:if>

</body>
</html>