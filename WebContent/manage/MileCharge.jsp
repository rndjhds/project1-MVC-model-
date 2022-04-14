<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마일리지충전</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 마일리지 유효성검사 외부 자바스크립트 파일 불러오기 -->
<script src="./manage/mile.js"></script>

<script src="<%=request.getContextPath() %>/manage/mile.js"></script>

</head>
<body>

<form method=post action="<%=request.getContextPath()%>/MileChargeAction.managedo">
	<input type="hidden" name="member_id" value="${param.member_id}">
	<input type="hidden" name=member_mile value="${param.member_mile}">
	<table width=500 align="center" border=1>
	<caption>마일리지 충전<br><br></caption>
		<tr>
		<th colspan=3>${param.member_id}님</th>		
		</tr>		
		<tr>
			<th>마일리지 직접입력</th>
			<td colspan=2>
			<input type="text" name="mile1" id="mile1" >
			</td>
		</tr>
		 
		<tr>
		<th colspan=2>등급 수정</th>
		<td><select id="grade" name="member_grade">
		    	<option value="${param.member_grade}">${param.member_grade}</option> 
		    	<option value="bronze">bronze</option>
		    	<option value="silver">silver</option>
		    	<option value="gold">gold</option>
		    	<option value="diamond">diamond</option>
		    </select>	</td> <!-- 마일리지 충전할 아이디 선택하고 얼마나 충전을 할지? -->
		</tr>		
		<tr align="center">
			<td colspan=3>
				
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
	
<%@ include file="/share/footer.jsp" %>
</body>
</html>