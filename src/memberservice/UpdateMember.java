package memberservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class UpdateMember implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UpdateMember");
		
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO member = dao.getMember(member_id);	// 1명의 상세정보 구하기
		System.out.println("수정 폼:"+member);
		
		// 공유 설정
		request.setAttribute("member", member);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/memberUpdate.jsp");
		return forward;
	}

}
