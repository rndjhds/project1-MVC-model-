package manageservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManageDAO;
import dao.SaleDAO;
import model.BookDTO;
import model.MemberDTO;
import service.Action;
import service.ActionForward;

public class ManageAddAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//board add action참조
		System.out.println("sale1 success");
		
		//session 또는 request로 받는다. id값과 상품 번호를 받아서 리스트 쪽으로 전달
		HttpSession session = request.getSession();
		session.setAttribute("member_id", "test"); // 테스트용
//		session.setAttribute("book_num", 5100); // 테스트용
		String member_id = (String)session.getAttribute("member_id");
//		int book_num = (Integer)session.getAttribute("book_num");
		
		ManageDAO dao = ManageDAO.getInstance();	//dao는 공통으로 사용한다
		MemberDTO member = dao.getMember(member_id);	//1명의 상세정보 구하기
//		BookDTO book = dao.getBook(book_num);	// 책하나의 정보
		
		int result1 = dao.insert(member);		// 원문 글작성
			
		if(result1 == 1) System.out.println("글작성 성공1");
		
		
		request.setAttribute("member", member);
//		request.setAttribute("book", book);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);    // disaptcher 방식으로 포워딩
		forward.setPath("./ManageAction.managedo");
		
		
		
		
			
		return forward;
	}
	
	
	
}
