package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardservice.BoardDetailAction;
import boardservice.BoardAlert;
import boardservice.BoardDeleteAction;
import boardservice.BoardInsertAction;
import boardservice.BoardListAction;
import boardservice.BoardReplyAction;
import boardservice.BoardReplyForm;
import boardservice.BoardUpdateAction;
import boardservice.BoardUpdateForm;
import service.Action;
import service.ActionForward;

@WebServlet("*.bdo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI);
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);

		Action action = null;
		ActionForward forward = null;

		// 글 목록
		if(command.equals("/BoardListAction.bdo")) {
			try {
				action = new BoardListAction();
				forward =action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		// 상세 페이지
		} else if(command.equals("/BoardDetailAction.bdo")) {
			try {
				action = new BoardDetailAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		// 글 작성 폼
		} else if(command.equals("/BoardInsertForm.bdo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/board_insert.jsp");
			
		// 글 작성
		} else if(command.equals("/BoardInsertAction.bdo")) {
			try {
				action = new BoardInsertAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		// 댓글 폼
		} else if(command.equals("/BoardReplyForm.bdo")) {
			try {
				action = new BoardReplyForm();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		// 댓글 작성
		} else if(command.equals("/BoardReplyAction.bdo")) {
			try {
				action = new BoardReplyAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		// 수정 폼
		} else if(command.equals("/BoardUpdateForm.bdo")) {
			try {
				action = new BoardUpdateForm();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		// 글 수정
		} else if(command.equals("/BoardUpdateAction.bdo")) {
			try {
				action = new BoardUpdateAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		// 삭제 폼
		} else if(command.equals("/BoardDeleteForm.bdo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/board_delete.jsp");
			
		// 글 삭제
		} else if(command.equals("/BoardDeleteAction.bdo")) {
			try {
				action = new BoardDeleteAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
			e.printStackTrace();
			}
			
		// 로그인 경고
		} else if(command.equals("/BoardAlert.bdo")) {
			try {
				action = new BoardAlert();
				forward = action.execute(request, response);
			} catch(Exception e) {
			e.printStackTrace();
			}
		}
		
		// 포워딩 처리
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	} // doProcess end

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");
		doProcess(request, response);

	}

}
