$(function(){
	$("form").submit(function(){
		if($("#book_name").val()==""){
			alert("도서제목을 입력해주세요.");
			$("#book_name").focus();
			return false;
		}else if($("#book_author").val()==""){
			alert("도서저자를 입력해주세요.");
			$("#book_author").focus();
			return false;
		}else if($("#book_price").val()==""){
			alert("도서가격을 입력해주세요.");
			$("#book_price").focus();
			return false;
		}else if($("#book_stock").val()==""){
			alert("도서재고량을 입력해주세요.");
			$("#book_stock").focus();
			return false;
		}else if($("#book_pb").val()==""){
			alert("도서출판사를 입력해주세요.");
			$("#book_pb").focus();
			return false;
		}else if($("#book_category").val()==""){
			alert("도서카테고리를 입력해주세요.");
			$("#book_category").focus();
			return false;
		}else if($("#book_content").val()==""){
			alert("도서내용을 입력해주세요.");
			$("#book_content").focus();
			return false;
		}
	});
	
});