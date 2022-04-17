package cartservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.CartDAO;
import dao.MemberDAO;
import dao.OrderDAO;
import model.BookDTO;
import model.CartDTO;
import model.OrderDTO;
import service.Action;
import service.ActionForward;

public class CartBuy implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartBuy");
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("id");
		int member_mile = (int)session.getAttribute("member_mile");
		String member_name = (String)session.getAttribute("member_name");
		
		String[] cartsel = request.getParameterValues("cartsel");
		
		for(String cart_no : cartsel) {
			System.out.println("체크박스값 : "+cart_no);
			
			CartDAO dao = CartDAO.getInstance();
			
			int book_num = dao.cartGetBookNum(cart_no);
			
			BookDAO bdao = BookDAO.getInstance();
			BookDTO book = bdao.getDetailBook(book_num);
			
			int rmile = member_mile - book.getBook_price();
			
			MemberDAO mdao = MemberDAO.getInstance();
			OrderDAO odao = OrderDAO.getInstance();
			OrderDTO order = new OrderDTO();
			order.setMember_id(member_id);
			order.setMember_name(member_name);
			order.setBook_num(book_num);
			order.setBook_name(book.getBook_name());
			order.setBook_price(book.getBook_price());
			
			int result = odao.buyInsert(order);
			
			if(result==1) System.out.println("장바구니 인서트 성공");
			
			int result2 = mdao.mileAdd(member_id, rmile);
		      if(result2==1) System.out.println("장바구니 마일리지 차감 성공");
			
		      session.setAttribute("member_mile", rmile);
		      
		   // 장바구니 삭제 아래에 구현
		      
		      int cart_no1 = Integer.parseInt(cart_no);
	          dao.cartDel(cart_no1);
			
		}
		
		System.out.println("장바구니 구매 최종 성공");
		
		ActionForward forward = new ActionForward();
		forward.setPath("/CartListAction.cdo");
		return forward;
	}

}
