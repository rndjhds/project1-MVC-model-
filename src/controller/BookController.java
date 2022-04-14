package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookservice.BookDelete;
import bookservice.BookDetail;
import bookservice.BookDomestic;
import bookservice.BookInsert;
import bookservice.BookListAction;
import bookservice.BookMain;
import bookservice.BookModify;
import bookservice.BookModifyAction;
import service.Action;
import service.ActionForward;

@WebServlet("*.pdo")
public class BookController extends HttpServlet {
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
		
		
		if(command.equals("/BookMain.pdo")) {
			try {
				action = new BookMain();
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
	
		// 상품 등록폼
		}else if (command.equals("/BookAdd.pdo")) {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("./book/bookaddview.jsp");
		// 상품등록
		}else if(command.equals("/BookInsert.pdo")) {
			try {
				action = new BookInsert();
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		// 상품 목록
		}else if(command.equals("/BookListAction.pdo")) {
			try {
				action = new BookListAction();
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		// 상품 수정 페이지로 이동
		}else if(command.equals("/BookModify.pdo")) {
			try {
				action = new BookModify();
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		// 상품수정 등록
		}else if(command.equals("/BookModifyAction.pdo")) {
			try {
				action = new BookModifyAction();
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		// 상품 삭제
		}else if(command.equals("/BookDelete.pdo")) {
			try {
				action = new BookDelete();
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		// 상품 상세 페이지
		}else if(command.equals("/BookDetail.pdo")) {
			try{
				action = new BookDetail();
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		// 카테고리별 출력
		}else if(command.equals("/BookDomestic.pdo")) {
			try {
				action = new BookDomestic();
				forward = action.execute(request, response);
			}catch (Exception e) {
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
