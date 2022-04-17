package manageservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManageDAO;
import dao.MemberDAO;
import model.ManageDTO;
import service.Action;
import service.ActionForward;

public class MileChargeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
			System.out.println("MileChargeAction");
			
			request.setCharacterEncoding("utf-8");
			
			String member_id = request.getParameter("member_id");			
			int member_mile = Integer.parseInt(request.getParameter("member_mile"));			
//			int mile = Integer.parseInt(request.getParameter("mile"));
			int mile1 = Integer.parseInt(request.getParameter("mile1")); //직접입력
			String member_grade = request.getParameter("member_grade");	
			System.out.println("member_id:"+member_id);
			System.out.println("member_mile:"+member_mile);
//			System.out.println("mile:"+mile);
			System.out.println("mile1:"+mile1);
			System.out.println("member_grade:"+member_grade);			
			
			ManageDTO manage = new ManageDTO();
			manage.setMember_id(member_id);
//			manage.setMember_mile(member_mile + mile);
			manage.setMember_mile(member_mile + mile1);
			manage.setMember_grade(member_grade);			
			
			ManageDAO dao = ManageDAO.getInstance();
						
			int result = dao.mileCharge(manage);	// 마일리지 증가 메소드
			if(result == 1) {
					System.out.println("마일리지 증가 성공");
				}
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/ManageAction.managedo");
			
			return forward;
		
	}

}
