package boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardDTO;
import service.Action;
import service.ActionForward;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardReplyAction");
		
		request.setCharacterEncoding("utf-8");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int board_ref = Integer.parseInt(request.getParameter("board_ref"));
		int board_lev = Integer.parseInt(request.getParameter("board_lev"));
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		String page = request.getParameter("page");
		
		BoardDTO board = new BoardDTO();
		board.setBoard_num(board_num);
		board.setBoard_ref(board_ref);
		board.setBoard_lev(board_lev);
		board.setBoard_seq(board_seq);
		board.setBoard_writer(request.getParameter("board_writer"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		board.setBoard_pw(Integer.parseInt(request.getParameter("board_pw")));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.reply(board);			// 댓글 작성
		if(result == 1) System.out.println("댓글 작성 성공");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.bdo?page="+page);
		
		return forward;
	}

}
