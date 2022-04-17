package memberservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class MileAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MileAddAction");
		
		request.setCharacterEncoding("utf-8");
		
		int mile = Integer.parseInt(request.getParameter("mile"));
		System.out.println(mile);
		
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("id");
		System.out.println(sid);
		int smile = (int) session.getAttribute("member_mile");
		System.out.println(smile);
		int totalmile = mile+smile;
		System.out.println(totalmile);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.mileAdd(sid, totalmile);	// 마일리지 증가 메소드
		if(result == 1) 
			{
				System.out.println("마일리지 증가 성공");
				session.setAttribute("member_mile", totalmile);
			}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BookMain.pdo");
		
		return forward;
	
	
	}

}
