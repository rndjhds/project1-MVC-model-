package boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardDTO;
import service.Action;
import service.ActionForward;

public class BoardUpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardUpdateForm");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = dao.getDetail(board_num);		// 상세정보
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/board_update.jsp");
		
		return forward;
	}

}
