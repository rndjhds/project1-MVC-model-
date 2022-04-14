package cartservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import model.CartDTO;
import service.Action;
import service.ActionForward;

public class CartAdd implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartAdd");
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("id");
		System.out.println("회원아이디 : "+sid);
		
		String book_name = request.getParameter("book_name");
		System.out.println("책이름 : "+book_name);
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		System.out.println("책번호 : "+book_num);
		int book_price = Integer.parseInt(request.getParameter("book_price"));
		System.out.println("책가격: "+book_price);
		
		CartDTO cart = new CartDTO();
		cart.setMember_id(sid);
		cart.setCbook_num(book_num);
		cart.setCbook_name(book_name);
		cart.setCbook_price(book_price);
		
		CartDAO dao = CartDAO.getInstance();
		int result = dao.cartAdd(cart);
		if(result == 1) {
			System.out.println("장바구니 담기 성공");
			int cartcount = dao.getCount(sid);
	        session.setAttribute("cartcount", cartcount);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/CartListAction.cdo");
		return forward;
	
	}

}
