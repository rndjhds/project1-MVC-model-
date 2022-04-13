$(document).ready(function() {
	$("form").submit(function() {
		if ($("#board_writer").val() == "") {
			alert("이름을 입력 하세요.");
			$("#board_writer").focus();
			return false;
		}
		if ($("#board_pw").val() == "") {
			alert("비밀번호를 입력 하세요.");
			$("#board_pw").focus();
			return false;
		}
		if ($("#board_subject").val() == "") {
			alert("제목을 입력 하세요.");
			$("#board_subject").focus();
			return false;
		}
		if ($("#board_content").val() == "") {
			alert("내용을 입력 하세요.");
			$("#board_content").focus();
			return false;
		}
	});
});