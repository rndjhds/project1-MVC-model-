package bookservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.BookDTO;
import service.Action;
import service.ActionForward;

public class BookMain implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BookMain");
		
		int page = 1;
		int limit = 8; // 한 페이지에 출력할 데이터 갯수 기본변수2
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1; // 추출하기 위한 시작 번호, 이 둘은 출력되는 목록의 갯수
		int endRow = page * limit;
		
		BookDAO dao = BookDAO.getInstance();

		int bookcount = dao.bookGetCount(); // 총 데이터 갯수 기본변수3
		System.out.println("bookcount:" + bookcount);

		List<BookDTO> booklist = dao.bookGetList(startRow, endRow);
		System.out.println("booklist:" + booklist);

		// 총 페이지
		int pageCount = bookcount / limit + ((bookcount % limit == 0) ? 0 : 1);

		int startPage = ((page - 1) / 5) * limit + 1; // 1, 11, 21...
		int endPage = startPage + 5 - 1; // 10, 20, 30...

		if (endPage > pageCount)
			endPage = pageCount;

		request.setAttribute("page", page);
		request.setAttribute("bookcount", bookcount);
		request.setAttribute("booklist", booklist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		
		return forward;
	}
	

}
