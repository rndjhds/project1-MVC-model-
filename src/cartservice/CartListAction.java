package cartservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import model.CartDTO;
import service.Action;
import service.ActionForward;

public class CartListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartListAction");
		
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("id");
		System.out.println(sid);
		
		CartDAO dao = CartDAO.getInstance();
		
		List<CartDTO> cartlist = dao.cartGetList(sid);
		System.out.println("cartlist : " + cartlist);
		
		request.setAttribute("cartlist", cartlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./cart/CartListView.jsp");
		
		return forward;
	}

}
