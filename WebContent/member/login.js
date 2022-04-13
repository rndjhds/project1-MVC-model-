$(document).ready(function(){
	$("form").submit(function(){
		
		if($.trim($("#member_id").val())==""){
			alert("ID를 입력하세요");
			$("#member_id").focus();
			return false;
		}
		
		if($.trim($("#member_pw").val())==""){
			alert("비밀번호를 입력하세요");
			$("#member_pw").focus();
			return false;
		}
		
	});
});