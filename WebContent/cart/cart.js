$(document).ready(function(){   

$("form").submit(function(){
      
   if($("input:checkbox[name='cartsel']:checked").length < 1){
         alert("상품을 선택하세요!!");
         
         return false;
      }   
}); 
}); 