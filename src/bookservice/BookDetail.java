package bookservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.BookDTO;
import service.Action;
import service.ActionForward;

public class BookDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BookDetail");
		
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		String page = request.getParameter("page");
		
		BookDAO dao = BookDAO.getInstance();
		BookDTO book = dao.getDetailBook(book_num);
		
		request.setAttribute("book", book);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./book/bookdetailview.jsp");
		
		return forward;
	}

}
