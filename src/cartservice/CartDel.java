package cartservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import service.Action;
import service.ActionForward;

public class CartDel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartDel");
		
		request.setCharacterEncoding("utf-8");
	      
	    HttpSession session = request.getSession();
		
		String sid = (String) session.getAttribute("id");
		
		int cart_no = Integer.parseInt(request.getParameter("cart_no"));
		
		CartDAO dao = CartDAO.getInstance();
		
		int result = dao.cartDel(cart_no);
		
		if(result == 1) {
			System.out.println("장바구니 목록 1개 삭제 성공");
			int cartcount = dao.getCount(sid);
	        session.setAttribute("cartcount", cartcount);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/CartListAction.cdo");
		
		return forward;
	}

}
