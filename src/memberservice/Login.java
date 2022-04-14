package memberservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class Login implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Login");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.memberAuth(member_id, member_pw);
		if(result == 1) {
			System.out.println("회원 인증 성공");
			MemberDTO member = new MemberDTO();
			member = dao.getMember(member_id);
			String member_grade = member.getMember_grade();
			int member_mile = member.getMember_mile();
			String member_name = member.getMember_name();
			
			CartDAO cdao = CartDAO.getInstance();
	        int cartcount = cdao.getCount(member_id);
	         
	        session.setAttribute("id", member_id);
	        session.setAttribute("member_grade", member_grade);
	        session.setAttribute("member_mile", member_mile);
	        session.setAttribute("member_name", member_name);
	        session.setAttribute("cartcount", cartcount);
			
		}else {					// 회원 인증 실패
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BookMain.pdo");
		return forward;
	}

}
