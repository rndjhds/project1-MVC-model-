package boardservice;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardDTO;
import service.Action;
import service.ActionForward;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDetailAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.rcUpdate(board_num);						// 조회수
		BoardDTO board = dao.getDetail(board_num);		// 상세정보
		
		String content = board.getBoard_content().replace("\n", "<br>");
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		request.setAttribute("content", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/board_view.jsp");
		
		return forward;
		
		
	}

}
