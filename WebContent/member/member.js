$(document).ready(function(){	
	
	// ID 중복검사
	$("#idcheck").click(function(){
		if($("#member_id").val()==""){
			alert("ID를 입력하세요");
			$("#member_id").focus();
			return false;
		}else{
			
			var id = $("#member_id").val();	
			
			$.ajax({
				type:"post",
				url:"/bookpro2/Idcheck.mdo",
				data:{"member_id":id},
				datatype:"text",
				success:function(data){
//					alert(data);
					
					if(data==1){	// 중복 ID
						$("#myid").text("중복 ID");
						$("#member_id").val("").focus();
					}else{			// 사용 가능한 ID
						$("#myid").text("사용 가능한 ID");
						$("#member_pw").focus();
					}					
				}
			});			
		}		
	});
		
	
	// 연락처 뒷자리로 포커스 이동
	$("#member_phone1").keyup(function(){
		if($("#member_phone1").val().length == 3)
			$("#member_phone2").focus();
	});
	$("#member_phone2").keyup(function(){
		if($("#member_phone2").val().length == 4)
			$("#member_phone3").focus();
	});
	
	
	// 도메인 선택
	$("#email").change(function(){
		if($("#email").val() == ""){	// 직접 입력 선택	
//			$("#domain").attr("readonly", false);
			$("#member_domain").removeAttr("readonly");
			$("#member_domain").val("").focus();			
		}else{							// 도메인명 선택
			$("#member_domain").val($("#email").val());
		    $("#member_domain").attr("readonly","readonly");
		}
	});
	
	
	// 유효성 검사
	$("form").submit(function(){
		
		if($("#member_id").val() == ""){
			alert("ID를 입력하세요");
			$("#member_id").focus();
			return false;
		}		
		if($("#member_pw").val()==""){
			alert("비밀번호를 입력하세요");
			$("#member_pw").focus();
			return false;
		}		
		if($("#member_name").val()==""){
			alert("이름을 입력하세요");
			$("#member_name").focus();
			return false;
		}
		if($("#member_mailid").val()==""){
			alert("이메일 주소를 입력하세요");
			$("#member_mailid").focus();
			return false;
		}
		if($("#member_domain").val()==""){
			alert("도메인을 입력하세요");
			$("#member_domain").focus();
			return false;
		}
		if($("#member_phone1").val()==""){
			alert("연락처 앞자리를 입력하세요.");
			$("#member_phone1").focus();
			return false;
		}
		if(isNaN($("#member_phone1").val())){
			alert("숫자만 입력하세요.");
			$("#member_phone1").val("").focus();
			return false;
		}
		if($("#member_phone2").val()==""){
			alert("연락처 중간자리를 입력하세요.");
			$("#member_phone2").focus();
			return false;
		}
		if(isNaN($("#member_phone2").val())){
			alert("숫자만 입력하세요.");
			$("#member_phone2").val("").focus();
			return false;
		}
		if($("#member_phone3").val()==""){
			alert("연락처 끝자리를 입력하세요.");
			$("#member_phone3").focus();
			return false;
		}
		if(isNaN($("#member_phone3").val())){
			alert("숫자만 입력하세요.");
			$("#member_phone3").val("").focus();
			return false;
		}
		if($("#member_post").val()==""){
			alert("우편번호를 입력하세요.");
			$("#member_post").focus();
			return false;
		}
		if($("#member_address").val()==""){
			alert("주소를 입력하세요.");
			$("#member_address").focus();
			return false;
		}
		
	}); // submit() end		
	
});  // ready() end