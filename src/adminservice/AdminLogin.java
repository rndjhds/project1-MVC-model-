package adminservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import model.BookAdminDTO;
import service.Action;
import service.ActionForward;

public class AdminLogin implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminLogin");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		
		String admin_id = request.getParameter("admin_id");
		String admin_pw = request.getParameter("admin_pw");
		
		BookDAO dao = BookDAO.getInstance();
		BookAdminDTO admindto = dao.getDetailAdmin(admin_id);
		
		if(admindto.getAdmin_id().equals(admin_id)) {
			if(admindto.getAdmin_pw().equals(admin_pw)) {
				session.setAttribute("id", admin_id);
			}else {
				out.println("<script>");
				out.println("alert('비밀번호가 틀렸습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				
				return null;
			}
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("share/AdminView.jsp");
		
		
		return forward;
	}

}
