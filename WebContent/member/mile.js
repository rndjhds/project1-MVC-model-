$("form").submit(function(){
	if($("#mile").is(":checked")==false){
			alert("원하시는 충전금액을 선택하세요");
			return false;
		}
	
});