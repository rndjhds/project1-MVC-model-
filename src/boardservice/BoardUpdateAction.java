package boardservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardDTO;
import service.Action;
import service.ActionForward;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardUpdateAction");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int board_pw = Integer.parseInt(request.getParameter("board_pw"));
		String page = request.getParameter("page");
		
		BoardDTO board = new BoardDTO();
		board.setBoard_num(board_num);
		board.setBoard_writer(request.getParameter("board_writer"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO old = dao.getDetail(board_num);		// 상세정보
		
		// 비밀번호
		if(old.getBoard_pw() == board_pw) {
			int result = dao.update(board);				// 글 수정
			if(result == 1) System.out.println("글 수정 성공");
			
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardDetailAction.do?board_num="+board_num+"&page="+page);
		
		return forward;
	}

}
