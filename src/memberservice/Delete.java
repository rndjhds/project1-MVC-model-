package memberservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class Delete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Delete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO old = dao.getMember(member_id);
		
		// 비밀번호 비교
		if(old.getMember_pw().equals(member_pw)) {	// 비밀번호 일치시
			int result = dao.delete(member_id);
			if(result == 1) System.out.println("회원 탈퇴 성공");
			
			session.invalidate();
		}else {		// 비밀번호 불일치시
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}

}
