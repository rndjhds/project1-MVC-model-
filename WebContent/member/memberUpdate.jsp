<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/share/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
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

<!-- 외부 자바스크립트 파일  -->
<script src="<%=request.getContextPath()%>/member/member.js"></script>

</head>
<body>

<form method="post" action="<%=request.getContextPath() %>/Update.mdo"> 
<input type="hidden" name="member_id" value="${member.member_id}">
<table width=500  height=300 align=center class="tb">
	<tr>
		<th colspan=2>회원 정보 수정</th>
	</tr>
	<tr><td>아이디</td>
		<td>		
			${member.member_id}	
		</td>
	</tr>
	<tr><td>비밀번호</td>
		<td><input type=password id="member_pw" name="member_pw"></td>
	</tr>
	<tr><td>이름</td>
		<td><input type=text id="member_name" name="member_name"
		           value="${member.member_name}"></td>
	</tr>
	</tr>
	<tr><td>이메일</td>
		<td><input type=text size=10 id="member_mailid" 
					name="member_mailid" value="${member.member_mailid}">@
		    <input type=text size=10 id="member_domain" 
		    		name="member_domain" value="${member.member_domain}">
		    <select id="email">
		    	<option value="">직접입력</option>
		    	<option value="naver.com">네이버</option>
		    	<option value="daum.net">다음</option>
		    	<option value="nate.com">네이트</option>
		    	<option value="gmail.com">구글</option>
		    </select>		    
		 </td>
	</tr>
	<tr><td>연락처</td>
		<td><input type=text size=4 id="member_phone1" name="member_phone1" 
					maxlength=4 value="${member.member_phone1}">-
			<input type=text size=4 id="member_phone2" name="member_phone2" 
					maxlength=4 value="${member.member_phone2}">-
			<input type=text size=4 id="member_phone3" name="member_phone3" 
					maxlength=4 value="${member.member_phone3}">
		</td>
	</tr>
	<tr><td>우편번호</td>
		<td><input type=text size=5 id="member_post" name="member_post"
				   value="${member.member_post}">
			<input type=button value="우편번호 검색" 
			       onClick="openDaumPostcode()">
		</td>
	</tr>
	<tr><td>주소</td>
		<td><input type=text size=45 id="member_address" 
					name="member_address" value="${member.member_address}"></td>
	</tr>
		<tr><td>등급</td>
		<td>		
			${member.member_grade}	
		</td>
	</tr>
		<tr><td>마일리지</td>
		<td>		
			${member.member_mile}	
		</td>
	</tr>
	<tr><td colspan=2 align=center>
		<input type=submit value="수정" class="submit-btn">
		<input type="button" value="취소" onClick="history.go(-1)" class="submit-btn">
		<input type="button" value="회원 탈퇴" onClick="location.href='./DeleteMember.mdo'">
		</td>
	</tr>	
</table>
</form>

<%@ include file="/share/footer.jsp" %>

</body>
</html>