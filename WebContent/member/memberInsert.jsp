<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/share/header.jsp" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function openDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				document.getElementById('member_post').value = data.zonecode;
				document.getElementById('member_address').value = data.address;
			}
		}).open();
	}
</script>

<!-- 외부 자바스크립트 파일 -->
<script src="<%=request.getContextPath()%>/member/member.js"></script>

</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/MemberInsert.mdo">

	<h4 id="title">회원 가입폼</h4>
	<div class="mem">
		<table align="center" class="tb">
			<tr>
				<th>아이디</th>
				<td><input type=text autofocus="autofocus" id="member_id" name="member_id" size=30>
				<input type=button value="중복 확인" id="idcheck" class="click">
				<div id="myid"></div></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type=password id="member_pw" name="member_pw" size=30></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type=text id="member_name" name="member_name" size=30></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type=text size=10 id="member_mailid" name="member_mailid"> @ 
					<input type=text size=11 id="member_domain" name="member_domain">
					<select id="email">
						<option value="">직접입력</option>
						<option value="naver.com">네이버</option>
						<option value="daum.net">다음</option>
						<option value="nate.com">네이트</option>
						<option value="gmail.com">구글</option>
				</select></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type=text size=5 id="member_phone1" name="member_phone1" maxlength=4> - 
					<input type=text size=5 id="member_phone2" name="member_phone2" maxlength=4> - 
					<input type=text size=5 id="member_phone3" name="member_phone3" maxlength=4>
				</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type=text size=30 id="member_post" name="member_post">
					<input type=button value="우편번호 검색" onClick="openDaumPostcode()" class="click">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type=text size=30 id="member_address" name="member_address"></td>
			</tr>
		</table>
		
		<div class="btn1">
			<input type=submit value="회원 가입">
			<input type=reset value="취소">
		</div>
	</div>

 </form>

<%@ include file="/share/footer.jsp" %>

</body>
</html>