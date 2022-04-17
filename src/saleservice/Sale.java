package saleservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SaleDAO;
import dao.SaleDAO;
import model.BookDTO;
import model.MemberDTO;
import model.SaleDTO;
import service.Action;
import service.ActionForward;

public class Sale implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sale1 success");
		
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
		int book_num = Integer.parseInt((String)session.getAttribute("book_num"));
		
		SaleDAO dao = SaleDAO.getInstance();	//dao는 공통으로 사용한다
		MemberDTO member = dao.getMember(member_id);	//1명의 상세정보 구하기
		BookDTO book = dao.getBook(book_num);	// 책하나의 정보
		
		request.setAttribute("member", member);
		request.setAttribute("book", book);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);    // disaptcher 방식으로 포워딩
		forward.setPath("./Sale.jsp");
		
			
		
		return forward;
	}

}
