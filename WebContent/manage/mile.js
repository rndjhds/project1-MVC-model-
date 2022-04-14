$(document).ready(function(){
	$("form").submit(function(){
		
		if($.trim($("#grade").val())==""){
			alert("grade를 정하세요");
			$("#grade").focus();
			return false;
		}
		
		
		
	});
});