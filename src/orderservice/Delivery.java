package orderservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.OrderDTO;
import service.Action;
import service.ActionForward;

public class Delivery implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Delivery");
		
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		System.out.println("order_num=" + order_num);
		String status = "배송완료";
		OrderDAO dao = OrderDAO.getInstance();
//		OrderDTO order = new OrderDTO();
		
		int result = dao.orderStatusChange(order_num, status);
		if(result == 1)	System.out.println("배송완료 변경 성공");
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);        //dispatcher 방식으로 포워딩
//		forward.setPath("share/AdminView.jsp");
		forward.setPath("/OrderListAction.odo");
		
		return forward;
				
	}

}
