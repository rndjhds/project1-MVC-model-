package memberservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class Update implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Update");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		MemberDTO member = new MemberDTO();
		member.setMember_id(request.getParameter("member_id"));
		member.setMember_pw(request.getParameter("member_pw"));
		member.setMember_name(request.getParameter("member_name"));
		member.setMember_mailid(request.getParameter("member_mailid"));
		member.setMember_domain(request.getParameter("member_domain"));
		member.setMember_phone1(request.getParameter("member_phone1"));
		member.setMember_phone2(request.getParameter("member_phone2"));
		member.setMember_phone3(request.getParameter("member_phone3"));
		member.setMember_post(request.getParameter("member_post"));
		member.setMember_address(request.getParameter("member_address"));
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO old = dao.getMember(member.getMember_id());	// 1명의 상세정보 구하기

		// 비밀번호 비교
		if(old.getMember_pw().equals(member.getMember_pw())) {	// 비밀번호 일치시
			int result = dao.update(member);	// update SQL문 실행
			if(result == 1) System.out.println("회원 수정 성공");
		}else {	// 비밀번호 불일치시
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}

}
