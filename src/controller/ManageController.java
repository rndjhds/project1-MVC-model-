package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageservice.ManageAction;
import manageservice.ManageAddAction;
import saleservice.SaleAddAction;
import saleservice.SaleListAction;
import service.Action;
import service.ActionForward;


@WebServlet("*.managedo")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI);
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);

		Action action = null;
		ActionForward forward = null;
		
		if (command.equals("/ManageAddAction.managedo")) {
			try {
				action = new ManageAddAction(); // sale 클래스import
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}else if (command.equals("/ManageAction.managedo")) {
			try {
				action = new ManageAction(); // sale 클래스import
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
		
	} //doProcess end
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		doProcess(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		doProcess(request, response);
	
	}

}
