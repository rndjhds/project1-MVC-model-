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

public class BookDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BookDelete");
		
		request.setCharacterEncoding("utf-8");
		
		String path = request.getRealPath("bookupload");
		System.out.println("path"+path);
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String nowpage = request.getParameter("page");
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		
		BookDAO dao = BookDAO.getInstance();
		BookDTO book = dao.getDetailBook(book_num);
		
		int result = dao.bookDelete(book_num);
		if(result == 1) {
			System.out.println("삭제 성공");
		}
		
		if(book.getBook_img() != "") {
			File file = new File(path);
			file.mkdir();
			
			// bookupload 디렉토리의 모든 첨부파일을 구해오기
			File[] f = file.listFiles();
			for(int i=0; i<f.length; i++) {
				if(f[i].getName().equals(book.getBook_img())) {
					f[i].delete();
				}
			}
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BookListAction.pdo?page="+nowpage);
		
		return forward;
	}

}
