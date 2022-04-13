<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/admin/admin.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../share/header.jsp" %>
</head>
<body>

<%-- <%
session.setAttribute("id", "admin");
%> --%>


<form method="post" action="<%=request.getContextPath()%>/AdminLogin.ado">
<table border=1 width=400 align=center>
	<tr>
		<th colspan=2>관리자 로그인</th>
	</tr>
	<tr>
		<td>관리자 아이디</td>
		<td><input type=text name="admin_id" id="admin_id" width=100%>
		<div id="idCheck"></div>	<!-- 관리자 로그인을 할수있는 아이디 여부 판단 -->
		</td>
	</tr>
	<tr>
		<td>관리자 비밀번호</td>
		<td colspan=2><input type=text name="admin_pw" id="admin_pw">
		
		</td>
		
	</tr>
	<tr align="center">
		<td colspan=2><input type=submit name="login_admin" id="login_admin" value="관리자로그인">
					  <input type="reset" name="login_admin" id="login_admin" value="취소"></td>
	</tr>
</table>
</form>

<%@ include file="../share/footer.jsp" %>
</body>
</html>