package bookservice;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookDAO;
import model.BookDTO;
import service.Action;
import service.ActionForward;

public class BookModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BookModifyAction");
		
		
		String path = request.getRealPath("bookupload");
		System.out.println("path"+path);
		
		int size = 1024 * 1024;	// 1MB까지 업로드 가능
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		MultipartRequest multi = new MultipartRequest(request, 
				path,
				size,
				"utf-8",
				new DefaultFileRenamePolicy());
		
		String nowpage = multi.getParameter("page");
		
		BookDAO dao = BookDAO.getInstance();
		
		BookDTO book = new BookDTO();
		book.setBook_num(Integer.parseInt(multi.getParameter("book_num")));
		book.setBook_name(multi.getParameter("book_name"));
		book.setBook_author(multi.getParameter("book_author"));
		book.setBook_price(Integer.parseInt(multi.getParameter("book_price")));
		book.setBook_stock(Integer.parseInt(multi.getParameter("book_stock")));
		book.setBook_pb(multi.getParameter("book_pb"));
		book.setBook_category(multi.getParameter("book_category"));
		book.setBook_img(multi.getFilesystemName("book_img"));
		
		String content = multi.getParameter("book_content").replace("\n", "<br>");
		book.setBook_content(content);
		
		int result = dao.bookUpdate(book);
		
		if(result == 1) {
			System.out.println("수정 성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BookListAction.pdo?page="+nowpage);
		
		return forward;
	}

}
