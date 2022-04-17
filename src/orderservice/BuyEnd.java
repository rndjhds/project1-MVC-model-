package orderservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.OrderDAO;
import model.BookAdminDTO;
import service.Action;
import service.ActionForward;

public class BuyEnd implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BuyEnd");
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String member_id = request.getParameter("member_id");
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		int book_price = Integer.parseInt(request.getParameter("book_price"));
		String status = "구매확정";
		String admin_id = "admin";
		OrderDAO dao = OrderDAO.getInstance();
		
		int result = dao.orderStatusChange(order_num, status);	// 마일리지 증가 메소드
		if(result == 1) System.out.println("구매확정 성공");
		
		BookDAO bdao = BookDAO.getInstance();
		BookAdminDTO admin = new BookAdminDTO();
		
		admin = bdao.getDetailAdmin(admin_id);
		
		int mile = admin.getAdmin_mile() + book_price;
		
		int result2 = bdao.mileAdd2(admin_id, mile);
		if(result2 == 1) System.out.println("마일리지 증가 성공");
		
	    session.setAttribute("admin_mile", mile);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/OrderConfirm.odo");
		return forward;
	}

}
