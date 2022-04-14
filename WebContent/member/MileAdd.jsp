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
<!-- <script src="./member/mile.js"></script> -->

</head>
<body>

<form method=post action="<%=request.getContextPath()%>/MileAddAction.mdo">
	<table width=500 align="center" class="tb">
	<caption>마일리지 충전<br><br></caption>
		<tr>
			<td>
				<input type="radio" name="mile" id="mile_5000" value="5000">5,000
			</td>
			<td>
				<input type="radio" name="mile" id="mile_10000" value="10000">10,000
			</td>
			<td>
				<input type="radio" name="mile" id="mile_30000" value="30000">30,000
			</td>
		</tr>
		<tr>	
			<td>
				<input type="radio" name="mile" id="mile_50000" value="50000">50,000
			</td>
			<td>
				<input type="radio" name="mile" id="mile_100000" value="100000">100,000
			</td>
			<td>
				<input type="radio" name="mile" id="mile_500000" value="500000">500,000
			</td>
		</tr>
		<tr align="center">
			<td colspan=3>
				<input type="submit" value="충전" class="submit-btn">
				<input type="reset" value="취소" class="submit-btn">
			</td>
		</tr>
	</table>
</form>
	
<%@ include file="/share/footer.jsp" %>
</body>
</html>