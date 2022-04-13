package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartservice.CartAdd;
import cartservice.CartDel;
import cartservice.CartListAction;
import service.Action;
import service.ActionForward;

@WebServlet("*.cdo")
public class CartController extends HttpServlet {
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

		// 기능 추가

		// 장바구니 담기
		if (command.equals("/CartAdd.cdo")) {
			try {
				action = new CartAdd();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// 장바구니 리스트 목록 가져오기
		} else if (command.equals("/CartListAction.cdo")) {
			try {
				action = new CartListAction();
				;
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// 장바구니 목록 1개 삭제
		} else if (command.equals("/CartDel.cdo")) {
			try {
				action = new CartDel();
				forward = action.execute(request, response);
				
			} catch (Exception e) {
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
		System.out.println("get");
		doProcess(request, response);
	}

}
