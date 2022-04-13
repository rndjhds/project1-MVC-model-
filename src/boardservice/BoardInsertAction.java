package boardservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardDTO;
import service.Action;
import service.ActionForward;

public class BoardInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardInsertAction");
		
		request.setCharacterEncoding("utf-8");
		
		BoardDTO board = new BoardDTO();
		board.setBoard_writer(request.getParameter("board_writer"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		board.setBoard_pw(Integer.parseInt(request.getParameter("board_pw")));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.insert(board);				// 글 작성
		if(result == 1) System.out.println("글 작성 성공");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.bdo");
		
		return forward;
	}

}
