package adminservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import service.Action;
import service.ActionForward;

public class AdminIdCheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("adminIdcheck");
		
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String admin_id = request.getParameter("admin_id");
		
		BookDAO dao = BookDAO.getInstance();
		int data = dao.admincheck(admin_id);			// 1이면 관리자 아이디 일치
		System.out.println(data);						// 0이면 관리자 아이디가 아님
		
		out.println(data);
		
		
		return null;
	}

}
