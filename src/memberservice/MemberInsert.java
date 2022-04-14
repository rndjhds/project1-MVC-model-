package memberservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class MemberInsert implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberInsert");
		
		request.setCharacterEncoding("utf-8");

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
		int result = dao.insert(member);	// 회원 가입
		if(result == 1) System.out.println("회원 가입 성공");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/memberLogin.jsp");
		
		return forward;
	}

}
