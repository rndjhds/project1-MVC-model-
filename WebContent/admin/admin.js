$(function(){
   $("form").submit(function(){
      if($("#admin_id").val()==""){
         alert("아이디를 입력하세요.");
         $("#admin_id").focus();
         return false;
      }else if($("#admin_pw").val()==""){
         alert("비밀번호를 입력하세요.");
         $("#admin_pw").focus();
         return false;
      }
   });
   
   $("#admin_id").keyup(function(){
      var admin_id = $("#admin_id").val();
      
      $.ajax({
         type:"post",
         url:"/bookpro/adminIdcheck.ado",
         data:{"admin_id":admin_id},
         datatype:"text",
         success:function(data){
            if(data == 1){
               $("#idCheck").text("관리자 아이디 입니다.");
               $("#admin_pw").removeAttr("disabled");
               $("#admin_pw").focus();
               
            }else{
               $("#idCheck").text("관리자 아이디가 아닙니다.");
               $("#admin_pw").attr("disabled",true);
            }
         }
   });
      
   });
});