package boardservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.ActionForward;

public class BoardAlert implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardAlert");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('로그인이 필요합니다.');");
		out.println("history.go(-1);");
		out.println("</script>");
		out.close();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.bdo");
		
		return forward;
	}

}
