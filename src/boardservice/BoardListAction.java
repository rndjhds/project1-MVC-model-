package boardservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.BoardDTO;
import service.Action;
import service.ActionForward;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardListAction");
		
		int page = 1;		// 현재 페이지 번호
		int limit = 10;		// 한 페이지에 출력할 데이터 갯수
		int pageSize = 5;	// 한 페이지에 출력할 버튼 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1;		// 시작 페이지
		int endRow = page * limit;					// 끝 페이지
		
		BoardDAO dao = BoardDAO.getInstance();
		int listcount = dao.getCount();				// 총 데이터 갯수
		System.out.println("listcount:" + listcount);
		
		List<BoardDTO> boardlist = dao.getList(startRow, endRow);	// 글 목록
		System.out.println("boardlist:" + boardlist);
		
		// 총 페이지
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);
		
		int startPage = ((page-1) / 5) * pageSize + 1;
		int endPage = startPage + 5 - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/board_list.jsp");
		
		return forward;
	}

}
