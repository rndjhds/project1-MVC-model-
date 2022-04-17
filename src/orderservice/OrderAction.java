package orderservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.MemberDAO;
import dao.OrderDAO;
import model.BookDTO;
import model.OrderDTO;
import service.Action;
import service.ActionForward;

public class OrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderAction");
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("id");
		String member_name = (String)session.getAttribute("member_name");
		int member_mile = (int)session.getAttribute("member_mile");
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		System.out.println(member_id);
		System.out.println(member_name);
		System.out.println("책번호 : "+book_num);
		
		BookDAO bdao = BookDAO.getInstance();
		BookDTO book = bdao.getDetailBook(book_num);
		
		int rmile = member_mile - book.getBook_price();
		
		MemberDAO dao = MemberDAO.getInstance();
		OrderDAO odao = OrderDAO.getInstance();
		OrderDTO order = new OrderDTO();
		order.setMember_id(member_id);
		order.setMember_name(member_name);
		order.setBook_num(book_num);
		order.setBook_name(book.getBook_name());
		order.setBook_price(book.getBook_price());
		
		int result = odao.buyInsert(order);
		
		if(result==1) System.out.println("구매 인서트 성공");
		
		int result2 = dao.mileAdd(member_id, rmile);
	      if(result2==1) System.out.println("마일리지 차감 성공");
		
	      session.setAttribute("member_mile", rmile);
		
		ActionForward forward = new ActionForward();
//		forward.setPath("./OrderListAction.odo");
		forward.setPath("/OrderConfirm.odo");
		return forward;
	}

}
