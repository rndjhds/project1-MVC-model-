package orderservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.MemberDAO;
import dao.OrderDAO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class OrderCancel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderCancel");
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String sid = (String) session.getAttribute("id");
		
		String member_id = request.getParameter("member_id");
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		int book_price = Integer.parseInt(request.getParameter("book_price"));
		String status = "주문취소";
		System.out.println(member_id);
		System.out.println(order_num);
		System.out.println(book_price);
		
		OrderDAO dao = OrderDAO.getInstance();
		int result = dao.orderStatusChange(order_num, status);	// 마일리지 증가 메소드
		if(result == 1) System.out.println("주문취소변경 성공");
		
		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO member = new MemberDTO();
		member = mdao.getMember(member_id);
		
		int mile = member.getMember_mile() + book_price;
		
		int result2 = mdao.mileAdd(member_id, mile);
		if(result2 == 1) 
		{
			System.out.println("마일리지 증가 성공");
			session.setAttribute("member_mile", mile);
			
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		if(sid.equals("admin")) {
			forward.setPath("/OrderListAction.odo");
		}else {
			forward.setPath("/OrderConfirm.odo");
		}
		
		return forward;
	}

}
